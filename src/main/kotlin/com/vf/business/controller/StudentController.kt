package com.vf.business.controller

import com.vf.business.business.dto.user.StudentDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.StudentService
import com.vf.business.business.validator.ValidStudent
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("students")
class StudentController ( val studentService: StudentService ) {

    @PostMapping("")
    fun createStudent( @Valid @ValidStudent @RequestBody dto: StudentDTO, errors: Errors) =
        if (errors.hasErrors()) throw ResourceNotFoundException(errors.allErrors[0].defaultMessage)
        else studentService.createStudent(dto)

    @PutMapping("/{id}")
    fun updateStudent( @Valid @ValidStudent @RequestBody dto: StudentDTO,
                       @NotNull @PathVariable("id") id: Int,
                       errors: Errors) =
            if (errors.hasErrors()) throw ResourceNotFoundException(errors.allErrors[0].defaultMessage)
            else studentService.createStudent(dto)

    @GetMapping("/{id}")
    fun getStudent( @PathVariable("id") id: Int ) =
        studentService.getStudent(id)

}