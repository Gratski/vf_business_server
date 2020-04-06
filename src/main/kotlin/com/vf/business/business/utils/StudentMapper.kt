package com.vf.business.business.utils

import com.vf.business.business.dao.models.Student
import com.vf.business.business.dto.user.StudentDTO

class StudentMapper {

    object Mapper {

        fun map( input: Student): StudentDTO =
            StudentDTO(
                    id = input.id,
                    firstName = input.firstName,
                    lastName = input.lastName,
                    email = input.email,
                    pwd = null,
                    active = input.active,
                    enabled = input.enabled,
                    createdAt = input.createdAt,
                    updatedAt =  input.updatedAt
            )


    }

}