package com.vf.business.controller.advice

import com.vf.business.business.dto.error.ErrorResponseDTO
import com.vf.business.business.exception.MissingArgumentsException
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@ControllerAdvice
class ValidationExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handle(e: MethodArgumentNotValidException) {
    }

    @ExceptionHandler(ResourceNotFoundException::class, MissingArgumentsException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun resource(e: ResourceNotFoundException): ErrorResponseDTO =
            ErrorResponseDTO(status = HttpStatus.BAD_REQUEST.value(), message = e.message)

    @ExceptionHandler(UnauthorizedOperationException::class)
    @ResponseStatus(HttpStatus.FORBIDDEN)
    fun handleForbiddenException(e: UnauthorizedOperationException) =
            ErrorResponseDTO(status = HttpStatus.FORBIDDEN.value(), message = e.message)

    @ExceptionHandler(ResourceConflictException::class)
    @ResponseStatus(HttpStatus.CONFLICT)
    fun handleConflictException(e: ResourceConflictException) =
            ErrorResponseDTO(status = HttpStatus.CONFLICT.value(), message = e.message)


}