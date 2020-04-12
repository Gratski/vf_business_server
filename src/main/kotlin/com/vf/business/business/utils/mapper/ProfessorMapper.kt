package com.vf.business.business.utils

import com.vf.business.business.dao.models.professor.Professor
import com.vf.business.business.dto.user.ProfessorDTO

class ProfessorMapper {

    object Mapper {

        fun map(input: Professor?): ProfessorDTO =
                ProfessorDTO(
                        id = input?.id,
                        email = input?.email,
                        firstName = input?.firstName,
                        lastName = input?.lastName,
                        active = input?.active,
                        enabled = input?.enabled,
                        createdAt = input?.createdAt,
                        updatedAt = input?.updatedAt
                )

    }

}