package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.*
import com.vf.business.business.dao.models.wallet.PaymentMethod
import com.vf.business.business.dao.models.wallet.TransactionDirection
import com.vf.business.business.dao.models.wallet.TransactionType
import com.vf.business.business.dao.models.wallet.WalletTransaction
import com.vf.business.business.dao.repo.PaymentMethodRepository
import com.vf.business.business.dao.repo.WalletTransactionRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.payments.CreatePaymentMethodDTO
import com.vf.business.business.dto.payments.PaymentMethodDTO
import com.vf.business.business.dto.payments.TransactionDTO
import com.vf.business.business.exception.CriticalSystemException
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.internal.CommissionService
import com.vf.business.business.service.itf.internal.WalletService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class WalletServiceImpl(
        val commissionService: CommissionService,
        val transactionRepo: WalletTransactionRepository,
        val paymentMethodRepo: PaymentMethodRepository
): WalletService {

    override fun deposit(attendants: Int, user: User) {
        // get commission amount based on attendants number
        val commissionAmount = commissionService.getCommissionValueByAttendants(attendants)
        if ( commissionAmount == 0.0 ) { return }

        val now = Date()
        val transaction = WalletTransaction(
                wallet = user.wallet!!,
                amount = commissionAmount,
                direction = TransactionDirection.IN,
                transactionType = TransactionType.PAYMENT,
                createdAt = now,
                updatedAt = now
        )

        transactionRepo.save(transaction)

    }

    override fun getTransactions(user: User, page: Int, size: Int): ResourcePage<TransactionDTO> {
        val wallet = user.wallet!!
        val pageRequest = PageRequest.of(page, size)
        val transactionsPage = transactionRepo.findByWallet(wallet, pageRequest)
        val resultsList = mutableListOf<TransactionDTO>()
        transactionsPage.forEach {
            val cur = TransactionDTO(
                id = it.id!!,
                amount = it.amount,
                transactionType = it.transactionType,
                direction = it.direction,
                createdAt = it.createdAt
            )
            resultsList.add(cur)
        }
        return ResourcePage(resultsList, transactionsPage.totalElements)
    }

    override fun getPaymentMethods(professor: Professor): ResourcePage<PaymentMethodDTO> {
        validateWalletExistence(professor)
        val wallet = professor.wallet!!
        val resultList = mutableListOf<PaymentMethodDTO>()
        wallet.paymentMethods.forEach {
            resultList.add(
                    PaymentMethodDTO(
                            id = it.id!!,
                            paymentEmail = it.paymentEmail,
                            isDefault = it.isDefault
                    )
            )
        }
        return ResourcePage(total = wallet.paymentMethods.size.toLong(), items = resultList)
    }

    override fun createPaymentMethod(professor: Professor, dto: CreatePaymentMethodDTO): CreateOperationResponseDTO {
        validateWalletExistence(professor)
        val pmOpt = paymentMethodRepo.findByWalletAndPaymentEmail(professor.wallet!!, dto.email)
        pmOpt.ifPresent {
            throw ResourceConflictException(Translator.toLocale(MessageCodes.WALLET_PAYMENT_METHOD_DUPLICATED))
        }

        val now = Date()
        professor.wallet?.paymentMethods?.forEach {}
        val pm = PaymentMethod(
                wallet = professor.wallet!!,
                isDefault = professor.wallet!!.paymentMethods.size == 0,
                paymentEmail = dto.email,
                createdAt = now,
                updatedAt = now
        )
        paymentMethodRepo.save(pm)
        return CreateOperationResponseDTO(id = pm.id!!)
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun makePaymentMethodDefault(professor: Professor, paymentMethodId: Int) {
        validateWalletExistence(professor)
        // set the new default
        val pm = getPaymentMethodById(paymentMethodId)

        // validates the payment method ownership
        validatePaymentMethodOwnership(professor, pm)

        pm.isDefault = true
        paymentMethodRepo.save(pm)

        // set the others to non default
        professor.wallet!!.paymentMethods?.forEach {
            if ( it.id == paymentMethodId ) {
                it.isDefault = false
                paymentMethodRepo.save(it)
            }
        }
    }

    override fun deletePaymentMethod(professor: Professor, paymentMethodId: Int) {
        val pm = getPaymentMethodById(paymentMethodId)
        // validates the payment method ownership
        validatePaymentMethodOwnership(professor, pm)

        paymentMethodRepo.delete(pm)
    }

    private fun validateWalletExistence(professor: Professor) {
        if (professor.wallet == null) {
            throw CriticalSystemException(Translator.toLocale(MessageCodes.WALLET_NOT_AVAILABLE))
        }
    }

    private fun validatePaymentMethodOwnership(professor: Professor, pm: PaymentMethod) {
        if (pm.wallet.belongsTo.id != professor.id) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }
    }

    private fun getPaymentMethodById(id: Int): PaymentMethod {
        val pmOpt = paymentMethodRepo.findById(id)
        pmOpt.orElseThrow{
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.PAYMENT_METHOD))))
        }
        return pmOpt.get()
    }
}