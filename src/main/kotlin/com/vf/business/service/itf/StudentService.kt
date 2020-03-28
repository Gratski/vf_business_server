package com.vf.business.service.itf

import com.vf.business.dto.user.StudentDTO

interface StudentService : UsersService {

    fun createStudent(Student: StudentDTO): Int

    fun getStudent(id: Int): StudentDTO

}