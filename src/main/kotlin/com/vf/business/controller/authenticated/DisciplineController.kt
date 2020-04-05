package com.vf.business.controller.authenticated

import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.service.itf.DisciplineService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${api.version}/disciplines")
class DisciplineController(val disciplineService: DisciplineService) {

    @GetMapping("/{id}")
    fun getDisciplineById(@PathVariable("id") id: Int): DisciplineDTO =
            disciplineService.getDiscipline(id)

    @PostMapping("/{id}/enable")
    fun enableDiscipline(@PathVariable("id") id: Int) =
            disciplineService.enableDisable(id, true)

    @PostMapping("/{id}/disable")
    fun disableDiscipline(@PathVariable("id") id: Int) =
            disciplineService.enableDisable(id, false)

}