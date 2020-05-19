package com.vf.business.business.dto.comms.support

data class SupportMessage(
        val id: Int,
        val to: String,
        val languageTag: String,
        val username: String,
        val ticketId: String? = null,
        val message: String
)