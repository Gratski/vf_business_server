package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.Student
import com.vf.business.business.dto.user.student.StudentDTO

class StudentMapper {

    object Mapper {

        fun map( input: Student): StudentDTO =
                StudentDTO(
                        id = input.id,
                        firstName = input.firstName,
                        lastName = input.lastName,
                        email = input.email,
                        pwd = null,
                        nationality = CountryMapper.Mapper.map(input.nationality!!),
                        livingIn = CountryMapper.Mapper.map(input.livingIn!!),
                        active = input.active,
                        enabled = input.enabled,
                        createdAt = input.createdAt,
                        updatedAt = input.updatedAt
                )


    }

}