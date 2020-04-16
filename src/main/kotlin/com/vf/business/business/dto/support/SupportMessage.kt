package com.vf.business.business.dto.support

import java.io.Serializable

data class SupportMessage(
        val id: Int,
        val to: String,
        val languageTag: String,
        val username: String,
        val ticketId: String? = null
)