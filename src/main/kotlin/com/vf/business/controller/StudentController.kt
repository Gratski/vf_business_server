package com.vf.business.controller

import com.vf.business.dto.user.StudentDTO
import com.vf.business.service.itf.StudentService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("students")
class StudentController ( val studentService: StudentService ) {

    @PostMapping("")
    fun createStudent( @RequestBody dto: StudentDTO ) =
        studentService.createStudent(dto)

    @GetMapping("/{id}")
    fun getStudent( @PathVariable("id") id: Int ) =
        studentService.getStudent(id)

}