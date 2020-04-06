package com.vf.business.business.service.itf.auth

import com.vf.business.business.dto.auth.SignInResponseDTO

interface AuthenticationService {

    fun signin(email: String, password: String): SignInResponseDTO

}