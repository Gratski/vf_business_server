package com.vf.business.business.utils

import com.vf.business.business.dao.models.discipline.DisciplineRepetition
import com.vf.business.business.dto.discipline.DisciplineRepetitionDTO

class DisciplineRepetitionMapper {

    object Mapper {

        fun map(input: DisciplineRepetition): DisciplineRepetitionDTO =
                DisciplineRepetitionDTO(
                        id = input.id,
                        professor = ProfessorMapper.Mapper.map(input.professor),
                        discipline = DisciplineMapper.Mapper.map(input.discipline),
                        startsAt = input.startsAt,
                        endsAt = input.endsAt,
                        enabled = input.enabled,
                        approved = input.approved,
                        createdAt = input.createdAt,
                        updatedAt = input.updatedAt
                )

        fun map(inputList: Collection<DisciplineRepetition>): Collection<DisciplineRepetitionDTO> {
            val resultList = arrayListOf<DisciplineRepetitionDTO>()
            inputList.forEach {
                resultList.add(map(it))
            }
            return resultList
        }

    }

}