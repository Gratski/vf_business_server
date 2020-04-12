package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.Discipline
import com.vf.business.business.dto.discipline.DisciplineDTO

class DisciplineMapper {

    object Mapper {

        fun map(input: Discipline?): DisciplineDTO =
                DisciplineDTO(
                        id = input?.id,
                        category = CategoryMapper.Mapper.map(input?.category),
                        professor = ProfessorMapper.Mapper.map(input?.languageContext?.professor),
                        designation = input?.designation,
                        description = input?.description,
                        duration = input?.duration,
                        imageUrl = input?.imageUrl,
                        updatedAt = input?.createdAt,
                        createdAt = input?.createdAt,
                        enabled = input?.enabled
                )
    }

}