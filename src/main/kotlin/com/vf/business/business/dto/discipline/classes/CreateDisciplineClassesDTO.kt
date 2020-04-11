package com.vf.business.business.dto.discipline.classes

import com.vf.business.common.RepetitionTypeEnum
import com.vf.business.common.WeekDayEnum
import java.util.Date

data class CreateDisciplineClassesDTO (
        val dateYear: Int,
        val dateMonth: Int,
        val dateDay: Int,
        val dateHour: Int,
        val dateMinutes: Int,
        val repetition: RepetitionTypeEnum,
        val numberOfRepetitions: Int,
        val repetitionWeekDays: Array<WeekDayEnum>
)