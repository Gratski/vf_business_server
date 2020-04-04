package com.vf.business.controller.authenticated

import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.service.itf.DisciplineService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.version}/disciplines")
class DisciplineController(val disciplineService: DisciplineService) {

    @GetMapping("/{id}")
    fun getDisciplineById(@PathVariable("id") id: Int): DisciplineDTO =
            disciplineService.getDiscipline(id)

}