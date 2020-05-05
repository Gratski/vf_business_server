package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.discipline.CreateDisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.UpdateDisciplineDTO
import com.vf.business.business.dto.discipline.classes.CreateDisciplineClassesDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.service.itf.internal.DisciplineService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/disciplines")
class DisciplineController(
        val disciplineService: DisciplineService,
        val usersService: UsersService
) {

    /**
     * Creates a new Discipline
     */
    @PostMapping("")
    fun createDiscipline(principal: Principal, @RequestBody dto: CreateDisciplineDTO): CreateOperationResponseDTO {
        val professor = (usersService.getUser(principal) as Professor)
        return disciplineService.createDiscipline(professor, dto)
    }

    /**
     * Enables an existing discipline
     */
    @PostMapping("/{id}/enable")
    fun enableDiscipline(@PathVariable("id") id: Int) =
            disciplineService.enableDisable(id, true)

    /**
     * Disables an existing discipline
     */
    @PostMapping("/{id}/disable")
    fun disableDiscipline(@PathVariable("id") id: Int) =
            disciplineService.enableDisable(id, false)


    @PostMapping("/{id}/classes")
    fun createDisciplineClasses(principal: Principal, @PathVariable("id") id: Int, @RequestBody dto: CreateDisciplineClassesDTO) {
        val professor = (usersService.getUser(principal) as Professor)
        disciplineService.createDisciplineClasses(id, professor, dto)
    }

    /**
     * Gets a discipline by its ID
     */
    @GetMapping("/{id}")
    fun getDisciplineById(@PathVariable("id") id: Int): DisciplineDTO =
            disciplineService.getDiscipline(id)

    /**
     * Updates an existing discipline
     */
    @PutMapping("/{id}")
    fun editDiscipline(@PathVariable("id") id: Int,
                       principal: Principal, @RequestBody dto: UpdateDisciplineDTO) {
        val professor = (usersService.getUser(principal) as Professor)
        disciplineService.updateDiscipline(id, dto,professor)
    }

    /**
     * Changes discipline picture
     */
    @PutMapping("/{id}/picture")
    fun changeDisciplinePicture(@PathVariable("id") id: Int,
                                principal: Principal, @RequestParam file: MultipartFile) {
        val professor = (usersService.getUser(principal) as Professor)
        disciplineService.changeDisciplinePicture(id, professor, file)
    }

}