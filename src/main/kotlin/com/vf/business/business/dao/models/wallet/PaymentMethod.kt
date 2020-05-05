package com.vf.business.business.dao.models.wallet

import com.vf.business.business.dao.models.AbstractEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "payment_method")
class PaymentMethod(
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "wallet_id")
        open var wallet: Wallet,

        @Column(name = "payment_email")
        open var paymentEmail: String,

        @Column(name = "is_default")
        open var isDefault: Boolean,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(
        id, createdAt, updatedAt
)