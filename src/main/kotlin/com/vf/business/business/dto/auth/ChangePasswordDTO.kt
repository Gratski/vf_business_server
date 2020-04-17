package com.vf.business.business.dto.auth

data class ChangePasswordDTO(
        val newPassword: String,
        val oldPassword: String
)