package com.vf.business.business.dto.comms.auth

data class PasswordRecoveryMessage(
        val to: String,
        val languageTag: String,
        val username: String,
        val token: String
)