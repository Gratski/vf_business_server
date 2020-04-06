package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.discipline.CreateDisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.UpdateDisciplineDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.service.itf.DisciplineService
import com.vf.business.business.service.itf.UsersService
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/disciplines")
class DisciplineController(
        val disciplineService: DisciplineService,
        val usersService: UsersService
) {

    @GetMapping("/{id}")
    fun getDisciplineById(@PathVariable("id") id: Int): DisciplineDTO =
            disciplineService.getDiscipline(id)

    @PostMapping("")
    fun createDiscipline(principal: Principal, @RequestBody dto: CreateDisciplineDTO): CreateOperationResponseDTO {
        val professor = (usersService.getUser(principal) as Professor)
        return disciplineService.createDiscipline(professor, dto)
    }

    @PutMapping("/{id}")
    fun editDiscipline(@PathVariable("id") id: Int, @RequestBody dto: UpdateDisciplineDTO) =
        disciplineService.updateDiscipline(id, dto)

    @PostMapping("/{id}/enable")
    fun enableDiscipline(@PathVariable("id") id: Int) =
            disciplineService.enableDisable(id, true)

    @PostMapping("/{id}/disable")
    fun disableDiscipline(@PathVariable("id") id: Int) =
            disciplineService.enableDisable(id, false)

}