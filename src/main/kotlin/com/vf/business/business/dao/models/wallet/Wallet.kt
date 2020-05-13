package com.vf.business.business.dao.models.wallet

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Currency
import com.vf.business.business.dao.models.CurrencyModel
import com.vf.business.business.dao.models.User
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

        @ManyToOne
        @JoinColumn(name = "currency_id")
        open var currency: CurrencyModel?,

        @OneToMany(mappedBy = "wallet")
        open var paymentMethods: MutableList<PaymentMethod> = mutableListOf(),

        @OneToMany(mappedBy = "wallet")
        open var transactions: MutableList<WalletTransaction> = mutableListOf(),

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}