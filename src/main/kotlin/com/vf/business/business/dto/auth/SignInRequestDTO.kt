package com.vf.business.business.dto.auth

data class SignInRequestDTO (
        val email: String,
        val password: String,
        val domain: AppDomainEnum
)