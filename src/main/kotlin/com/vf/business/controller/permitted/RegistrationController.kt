package com.vf.business.controller.permitted

import com.vf.business.business.dto.user.professor.RegistProfessorAccountDTO
import com.vf.business.business.service.itf.internal.ProfessorService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.version}/registrations")
class RegistrationController(
        val professorService: ProfessorService
) {

    /**
     * Registers a new professor account
     * Open to
     */
    @PostMapping("")
    fun registerProfessor(@RequestBody dto: RegistProfessorAccountDTO) {
        professorService.registerNewProfessorAccount(dto)
    }

}