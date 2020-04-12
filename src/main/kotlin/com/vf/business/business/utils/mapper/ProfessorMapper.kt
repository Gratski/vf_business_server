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
                        active = input?.active,
                        livingIn = CountryMapper.Mapper.map(input?.livingIn!!),
                        nationality = CountryMapper.Mapper.map(input?.nationality!!),
                        spokenLanguages = LanguageMapper.Mapper.map(input.spokenLanguages),
                        enabled = input?.enabled,
                        createdAt = input?.createdAt,
                        updatedAt = input?.updatedAt
                )

    }

}