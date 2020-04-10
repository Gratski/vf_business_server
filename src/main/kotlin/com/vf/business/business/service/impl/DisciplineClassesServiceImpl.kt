package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.classes.DisciplineClass
import com.vf.business.business.dao.models.discipline.DisciplineClassStatus
import com.vf.business.business.dao.models.discipline.DisciplineSlot
import com.vf.business.business.dao.models.discipline.RepetitionTypeEnum
import com.vf.business.business.dao.models.discipline.WeekDayEnum
import com.vf.business.business.dao.repo.DisciplineClassesRepository
import com.vf.business.business.exception.BadFormatException
import com.vf.business.business.service.itf.DisciplineClassesService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.stereotype.Service
import java.sql.Date
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.*


@Service
class DisciplineClassesServiceImpl(
        val disciplineClassesRepo: DisciplineClassesRepository
) : DisciplineClassesService {

    override fun createClassesUntil(slot: DisciplineSlot, repetitionType: RepetitionTypeEnum,
                                    weekDay: WeekDayEnum, startsAtHour: Int, startsAtMinutes: Int, duration: Int,
                                    numberOfRepetitions: Int
                                    ) {
        // TODO: Refactor this code
        val intervalOfDaysBetweenClasses = when ( repetitionType ) {
            RepetitionTypeEnum.NONE -> return
            RepetitionTypeEnum.DAILY -> 1
            RepetitionTypeEnum.WEEKLY -> 7
            else -> return
        }

        var nextDate = Date.valueOf(LocalDate.now().with(TemporalAdjusters.next(convertWeekDayToDayOfWeek(weekDay))))
        var times = 0;
        var reps = numberOfRepetitions
        while ( reps > 0 ) {

            val calendarDay = Calendar.getInstance()
            calendarDay.time = nextDate
            calendarDay.set(Calendar.HOUR_OF_DAY, 0)
            calendarDay.set(Calendar.MINUTE, 0)
            calendarDay.set(Calendar.MILLISECOND, 0)
            calendarDay.add(Calendar.DAY_OF_YEAR, ( times * intervalOfDaysBetweenClasses ))

            val calendarDate = calendarDay.clone() as Calendar
            calendarDate.set(Calendar.HOUR_OF_DAY, startsAtHour)
            calendarDate.set(Calendar.MINUTE, startsAtMinutes)

            val now = Calendar.getInstance()
            val newClass = DisciplineClass(
                    discipline = slot.discipline,
                    professor = slot.professor,
                    disciplineSlot = slot,
                    attendants = mutableListOf(),
                    status = DisciplineClassStatus.CREATED,
                    scheduledToDay = calendarDay.time,
                    scheduledTo = calendarDate.time,
                    createdAt = now.time,
                    updatedAt = now.time
            )
            disciplineClassesRepo.save(newClass)
            times++
            reps--
        }

    }

    private fun convertWeekDayToDayOfWeek(weekDay: WeekDayEnum): DayOfWeek {
        return when ( weekDay ) {
            WeekDayEnum.SUNDAY -> {DayOfWeek.SUNDAY}
            WeekDayEnum.MONDAY -> {DayOfWeek.MONDAY}
            WeekDayEnum.TUESDAY -> {DayOfWeek.TUESDAY}
            WeekDayEnum.WEDNESDAY -> {DayOfWeek.WEDNESDAY}
            WeekDayEnum.THURSDAY -> {DayOfWeek.THURSDAY}
            WeekDayEnum.FRIDAY -> {DayOfWeek.FRIDAY}
            WeekDayEnum.SATURDAY -> {DayOfWeek.SATURDAY}
            else -> throw BadFormatException(Translator.toLocale(MessageCodes.BAD_FORMAT, arrayOf(Translator.toLocale(MessageCodes.WEEK_DAY))))
        }
    }

}