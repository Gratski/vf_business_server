package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.user.ProfessorDTO

class ProfessorMapper {

    object Mapper {

        fun map(input: Professor?): ProfessorDTO =
                ProfessorDTO(
                        id = input?.id,
                        email = input?.email,
                        firstName = input?.firstName,
                        lastName = input?.lastName,
                        gender = input?.gender!!,
                        birthday = input?.birthday,
                        phoneNumber = input?.phoneNumber,
                        pictureUrl = input?.pictureUrl,
                        active = input?.active,
                        livingIn = CountryMapper.Mapper.map(input?.livingIn!!),
                        nationality = CountryMapper.Mapper.map(input?.nationality!!),
                        enabled = input?.enabled,
                        createdAt = input?.createdAt,
                        updatedAt = input?.updatedAt
                )

    }

}