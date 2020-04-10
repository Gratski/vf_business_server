package com.vf.business.business.service.itf

import com.vf.business.business.dao.models.discipline.DisciplineSlot
import com.vf.business.business.dao.models.discipline.RepetitionTypeEnum
import com.vf.business.business.dao.models.discipline.WeekDayEnum

interface DisciplineClassesService {

    fun createClassesUntil(
            slot: DisciplineSlot, repetitionType: RepetitionTypeEnum,
            weekDay: WeekDayEnum, startsAtHour: Int, startsAtMinutes: Int, duration: Int,
            numberOfRepetitions: Int
            )

}