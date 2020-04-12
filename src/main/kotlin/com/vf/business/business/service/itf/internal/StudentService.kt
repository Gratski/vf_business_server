package com.vf.business.business.service.itf.internal

import com.vf.business.business.dto.user.StudentDTO

interface StudentService : UsersService {

    fun createStudent(Student: StudentDTO): Int

    fun getStudent(id: Int): StudentDTO

}