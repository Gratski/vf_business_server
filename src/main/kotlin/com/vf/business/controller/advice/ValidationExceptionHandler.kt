package com.vf.business.controller.advice

import com.vf.business.business.dto.error.ErrorResponseDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(e: MethodArgumentNotValidException) {
    }

    @ExceptionHandler(ResourceNotFoundException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun resource(e: ResourceNotFoundException) {
        println(e.message)
    }

    @ExceptionHandler(UnauthorizedOperationException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleForbiddenException(e: UnauthorizedOperationException) =
            ErrorResponseDTO(status = 403, message = e.message)

}