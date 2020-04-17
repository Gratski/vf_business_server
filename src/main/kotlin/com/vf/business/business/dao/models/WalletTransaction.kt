package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "wallet_transaction")
class WalletTransaction(
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "wallet_id")
        open var wallet: Wallet,

        @Column(name = "amount")
        open var amount: Double,

        @Column(name = "direction")
        @Enumerated(EnumType.STRING)
        open var direction: TransactionDirection,

        @Column(name = "transaction_type")
        @Enumerated(EnumType.STRING)
        open var transactionType: TransactionType,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}