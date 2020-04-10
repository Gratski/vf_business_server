package com.vf.business.business.utils

import com.vf.business.business.dao.models.discipline.DisciplineSlot
import com.vf.business.business.dto.discipline.DisciplineSlotDTO

class DisciplineSlotMapper {

    object Mapper {

        fun map(input: DisciplineSlot?): DisciplineSlotDTO =
                DisciplineSlotDTO(
                        id = input?.id,
                        professor = ProfessorMapper.Mapper.map(input?.professor),
                        discipline = DisciplineMapper.Mapper.map(input?.discipline),
                        startsAtHour = input?.startsAtHour,
                        startsAtMinutes = input?.startsAtMinutes,
                        enabled = input?.enabled,
                        approved = input?.approved,
                        createdAt = input?.createdAt,
                        updatedAt = input?.updatedAt
                )

        fun map(inputList: MutableCollection<DisciplineSlot>?): MutableCollection<DisciplineSlotDTO> {
            val resultList = mutableListOf<DisciplineSlotDTO>()
            inputList?.forEach {
                resultList.add(map(it))
            }
            return resultList
        }

    }

}