package com.vf.business.business.service.itf.internal.auth

import com.vf.business.business.dto.auth.AppDomainEnum
import com.vf.business.business.dto.auth.SignInResponseDTO

interface AuthenticationService {

    fun signin(email: String, password: String, domain: AppDomainEnum): SignInResponseDTO

}