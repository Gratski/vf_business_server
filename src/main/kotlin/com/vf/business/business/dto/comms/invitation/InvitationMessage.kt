package com.vf.business.business.dto.comms.invitation

data class InvitationMessage(
        val to: Array<String>,
        val languageTag: String,
        val fromUsername: String
)