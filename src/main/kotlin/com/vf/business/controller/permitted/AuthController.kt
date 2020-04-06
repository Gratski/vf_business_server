package com.vf.business.controller.permitted

import com.vf.business.business.dto.auth.SignInRequestDTO
import com.vf.business.business.dto.auth.SignInResponseDTO
import com.vf.business.business.service.itf.auth.AuthenticationService
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/auth")
class AuthController ( private val authService: AuthenticationService) {

    @PostMapping("/signin")
    fun signin(@RequestBody signInRequest: SignInRequestDTO): SignInResponseDTO =
            authService.signin(signInRequest.email, signInRequest.password, signInRequest.domain)

    @GetMapping("/me")
    fun getAuthenticatedUser(principal: Principal) {
        println("Got user!")
    }

}