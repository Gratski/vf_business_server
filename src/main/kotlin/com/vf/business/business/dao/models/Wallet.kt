package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "wallet")
class Wallet(
        id: Int? = null,

        @OneToOne
        @JoinColumn(name = "belongs_to")
        open var belongsTo: User,

        @Column(name = "balance")
        open var balance: Double,

        @Column(name = "currency")
        open var currency: Currency = Currency.EUR,

        @OneToMany(mappedBy = "wallet")
        open var transactions: MutableList<WalletTransaction> = mutableListOf(),

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}