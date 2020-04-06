package com.vf.business.controller

import com.vf.business.business.dto.auth.SignInRequestDTO
import com.vf.business.business.dto.auth.SignInResponseDTO
import com.vf.business.business.service.itf.auth.AuthenticationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.version}/auth")
class AuthController ( private val authService: AuthenticationService) {

    @PostMapping("/signin")
    fun signin(@RequestBody signInRequest: SignInRequestDTO): SignInResponseDTO =
            authService.signin(signInRequest.email, signInRequest.email)

}