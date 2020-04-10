package com.vf.business.controller.advice

import com.vf.business.business.dto.error.ErrorResponseDTO
import org.springframework.http.HttpStatus
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class AuthenticationAdvice {

    @ExceptionHandler(BadCredentialsException::class, UsernameNotFoundException::class, CredentialsExpiredException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleAuthenticationExceptions(e: AuthenticationException): ErrorResponseDTO =
            ErrorResponseDTO(status = HttpStatus.UNAUTHORIZED.value(), message = e.message)

}