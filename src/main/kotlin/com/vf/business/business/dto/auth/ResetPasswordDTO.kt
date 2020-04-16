package com.vf.business.business.dto.auth

data class ResetPasswordDTO(
        val email: String,
        val newPassword: String,
        val pwdToken: String
)