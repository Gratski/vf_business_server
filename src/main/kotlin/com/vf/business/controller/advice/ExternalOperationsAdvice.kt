package com.vf.business.controller.advice

import com.vf.business.business.dto.error.ErrorResponseDTO
import com.vf.business.business.exception.ExternalOperationException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus

@ControllerAdvice
class ExternalOperationsAdvice {

    @ExceptionHandler(ExternalOperationException::class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleExternalOperationsExceptions(e: ExternalOperationException) : ErrorResponseDTO =
            ErrorResponseDTO(
                    status = HttpStatus.INTERNAL_SERVER_ERROR.value(),
                    message = e.message
            )

}