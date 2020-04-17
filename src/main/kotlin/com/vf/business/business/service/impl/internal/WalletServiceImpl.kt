package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.*
import com.vf.business.business.dao.repo.WalletTransactionRepository
import com.vf.business.business.service.itf.internal.CommissionService
import com.vf.business.business.service.itf.internal.WalletService
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

}