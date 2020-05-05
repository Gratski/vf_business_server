package com.vf.business.business.dto.payments

data class PaymentMethodDTO(
        val id: Int,
        val paymentEmail: String,
        val isDefault: Boolean
)