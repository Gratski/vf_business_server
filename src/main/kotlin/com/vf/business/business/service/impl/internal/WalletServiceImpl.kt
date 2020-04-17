package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.*
import com.vf.business.business.dao.repo.WalletTransactionRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.payments.TransactionDTO
import com.vf.business.business.service.itf.internal.CommissionService
import com.vf.business.business.service.itf.internal.WalletService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class WalletServiceImpl(
        val commissionService: CommissionService,
        val transactionRepo: WalletTransactionRepository
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

}