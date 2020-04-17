package com.vf.business.business.dto.payments

import com.vf.business.business.dao.models.TransactionDirection
import com.vf.business.business.dao.models.TransactionType
import java.util.Date

data class TransactionDTO(
    val id: Int,
    val amount: Double,
    val transactionType: TransactionType,
    val direction: TransactionDirection,
    val createdAt: Date
)