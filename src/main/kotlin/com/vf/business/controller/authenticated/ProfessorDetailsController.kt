package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.locatization.UpdateProfessorDetailsDTO
import com.vf.business.business.service.itf.internal.ProfessorDetailsService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/professor-details")
class ProfessorDetailsController(
        val professorDetailsService: ProfessorDetailsService,
        val usersService: UsersService
) {

    @PutMapping("/{id}")
    fun updateProfessorDetails(principal: Principal, @PathVariable("id") id: Int, @RequestBody dto: UpdateProfessorDetailsDTO) {
        val professor = (usersService.getUser(principal) as Professor)
        return professorDetailsService.updateProfessorDetails(id, professor, dto )
    }

}