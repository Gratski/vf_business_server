package com.vf.business.business.dto.discipline.slot

import com.vf.business.business.dao.models.discipline.RepetitionTypeEnum
import com.vf.business.business.dao.models.discipline.WeekDayEnum

data class CreateDisciplineSlotDTO(
        val startsAtHour: Int,
        val startsAtMinutes: Int,
        val weekDay: WeekDayEnum,
        val repetition: RepetitionTypeEnum
)

