package com.vf.business.business.utils

import com.vf.business.business.dao.models.discipline.Discipline
import com.vf.business.business.dto.discipline.DisciplineDTO

class DisciplineMapper {

    object Mapper {

        fun map(input: Discipline?): DisciplineDTO =
                DisciplineDTO(
                        id = input?.id,
                        professor = ProfessorMapper.Mapper.map(input?.professor),
                        designation = input?.designation,
                        description = input?.description,
                        category = CategoryMapper.Mapper.map(input?.category),
                        repetitions = DisciplineRepetitionMapper.Mapper.map(input?.repetitions),
                        updatedAt = input?.createdAt,
                        createdAt = input?.createdAt,
                        enabled = input?.enabled
                )

    }

}