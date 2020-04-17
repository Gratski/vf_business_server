package com.vf.business.business.dto.comms.invoice

data class InvoiceMessage(
        val to: String,
        val languageTag: String,
        val username: String,
        val docUrl: String,
        val invoiceId: String
)