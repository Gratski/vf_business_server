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
import org.springframework.web.bind.annotation.RestControllerAdvice

@ControllerAdvice
class AuthenticationAdvice {

    @ExceptionHandler(BadCredentialsException::class, UsernameNotFoundException::class, CredentialsExpiredException::class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    fun handleAuthenticationExceptions(e: AuthenticationException): ErrorResponseDTO =
            ErrorResponseDTO(status = 401, message = e.message)




}