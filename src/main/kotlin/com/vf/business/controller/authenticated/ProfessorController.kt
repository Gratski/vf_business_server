package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.user.professor.UpdateProfessorProfileDetailsDTO
import com.vf.business.business.service.itf.internal.ProfessorService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/professors")
class ProfessorController (
        val userService: UsersService,
        val professorService: ProfessorService
) {

    @PutMapping("me/profile-details")
    fun updateProfileDetails(principal: Principal, @RequestBody dto: UpdateProfessorProfileDetailsDTO) {
        val professor = (userService.getUser(principal) as Professor)
        professorService.updateProfessorProfileDetails(professor, dto)
    }

}