package com.vf.business.business.utils

import com.vf.business.business.dao.models.classes.DisciplineClass
import com.vf.business.business.dto.classes.VFClassDTO

class VFClassMapper {

    object Mapper {

        fun map(input: DisciplineClass): VFClassDTO =
                VFClassDTO(
                        id = input.id,
                        professor = ProfessorMapper.Mapper.map(input.professor),
                        discipline = DisciplineMapper.Mapper.map(input.discipline),
                        startedAt = input.startedAt,
                        endedAt = input.endedAt,
                        createdAt = input.createdAt,
                        updatedAt = input.updatedAt
                )

    }

}