package com.vf.business.controller.authenticated.user

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.user.student.CreateStudentDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.StudentService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.validator.ValidStudent
import org.springframework.validation.Errors
import org.springframework.web.bind.annotation.*
import java.security.Principal
import javax.validation.Valid
import javax.validation.constraints.NotNull

@RestController
@RequestMapping("students")
class StudentController (
        val studentService: StudentService,
        val usersService: UsersService
) {

    @PostMapping("")
    fun createStudent(@Valid @ValidStudent @RequestBody dto: CreateStudentDTO, errors: Errors) =
        if (errors.hasErrors()) throw ResourceNotFoundException(errors.allErrors[0].defaultMessage)
        else studentService.createStudent(dto)

    @PostMapping("/{id}/mute")
    fun muteStudent(principal: Principal, @PathVariable("id") id: Int ) {
        val professor = (usersService.getUser(principal) as Professor)
        studentService.muteStudent(professor, id)
    }

    @PostMapping("/{id}/unmute")
    fun unmuteStudent(principal: Principal, @PathVariable("id") id: Int ) {
        val professor = (usersService.getUser(principal) as Professor)
        studentService.unmuteStudent(professor, id)
    }

    @PutMapping("/{id}")
    fun updateStudent(@Valid @ValidStudent @RequestBody dto: CreateStudentDTO,
                      @NotNull @PathVariable("id") id: Int,
                      errors: Errors) =
            if (errors.hasErrors()) throw ResourceNotFoundException(errors.allErrors[0].defaultMessage)
            else studentService.createStudent(dto)

    @GetMapping("/{id}")
    fun getStudent( @PathVariable("id") id: Int ) =
        studentService.getStudent(id)

}