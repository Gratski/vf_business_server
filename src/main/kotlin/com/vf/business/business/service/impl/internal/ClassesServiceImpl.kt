package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.discipline.Discipline
import com.vf.business.business.dao.models.discipline.classes.DisciplineClass
import com.vf.business.business.dao.models.discipline.classes.DisciplineClassStatus
import com.vf.business.business.dao.repo.DisciplineClassesRepository
import com.vf.business.business.dto.discipline.classes.CreateDisciplineClassesDTO
import com.vf.business.business.dto.discipline.classes.VFClassDTO
import com.vf.business.business.events.EventKeyEnum
import com.vf.business.business.events.EventLabelsEnum
import com.vf.business.business.events.EventTypeEnum
import com.vf.business.business.exception.BadFormatException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.external.messaging.MessagingService
import com.vf.business.business.service.itf.internal.ClassesService
import com.vf.business.business.utils.VFClassMapper
import com.vf.business.common.RepetitionTypeEnum
import com.vf.business.common.WeekDayEnum
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import jdk.jfr.EventType
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters
import java.util.*
import kotlin.collections.HashMap

@Service
class ClassesServiceImpl(
        val classesRepo: DisciplineClassesRepository,
        val messagingService: MessagingService
) : ClassesService {

    override fun getActiveClasses(pageNumber: Int, size: Int): Page<VFClassDTO> {
        if (pageNumber < 0 || size <= 0)
            return Page.empty()

        val now = Date()
        val pageRequest = PageRequest.of((pageNumber * size), size)
        val classesPage = classesRepo.findActiveClasses(now, pageRequest)

        val resultList = arrayListOf<VFClassDTO>()

        classesPage?.iterator().forEach {
            resultList.add(VFClassMapper.Mapper.map(it))
        }

        return PageImpl<VFClassDTO>(resultList, pageRequest, classesPage.totalElements)
    }

    override fun getActiveClassesByCategory(category: Category, pageNumber: Int, size: Int): Page<VFClassDTO> {
        if (pageNumber < 0 || size <= 0)
            return Page.empty()

        val now = Date()
        val pageRequest = PageRequest.of((pageNumber * size), size)
        val classesPage: Page<DisciplineClass> = classesRepo.findActiveClassesByCategory(category, now, pageRequest)
        val resultList = arrayListOf<VFClassDTO>()


        return PageImpl<VFClassDTO>(resultList, pageRequest, classesPage.totalElements)
    }

    override fun createClassesFromUntil(dto: CreateDisciplineClassesDTO, discipline: Discipline) {
        // if there is no repetition
        if( dto.repetition == RepetitionTypeEnum.NONE ) {
            val targetDate = prepareCalendar(dto.dateDay,  dto.dateMonth, dto.dateYear, dto.dateHour, dto.dateMinutes)
            createSingleClass(discipline, targetDate.time)
        }
        // if the repetition is daily
        else if ( dto.repetition == RepetitionTypeEnum.DAILY ) {
            var dayNumber = 0
            var currentDate = prepareCalendar(dto.dateDay, dto.dateMonth, dto.dateYear, dto.dateHour, dto.dateMinutes).time

            var numberOfRepetitions = dto.numberOfRepetitions
            while ( numberOfRepetitions > 0 ) {

                val dateToStore = Calendar.getInstance()
                dateToStore.time = currentDate
                dateToStore.add(Calendar.DAY_OF_YEAR, dayNumber )
                dateToStore.set(Calendar.MILLISECOND, 0)

                // save class
                createSingleClass(discipline, dateToStore.time)
                numberOfRepetitions--
                dayNumber++
            }

        }
        // if the repetition is weekly
        else if( dto.repetition == RepetitionTypeEnum.WEEKLY ) {

            var dayNumber = 0
            var currentDate = prepareCalendar(dto.dateDay, dto.dateMonth, dto.dateYear, dto.dateHour, dto.dateMinutes).time

            var numberOfRepetitions = dto.numberOfRepetitions
            while ( numberOfRepetitions > 0 ) {

                dto.repetitionWeekDays?.forEach {

                    // find next date for the given week day
                    var nextWeekDay = java.sql.Date.valueOf(LocalDate.now().with(TemporalAdjusters.next(convertWeekDayToDayOfWeek(it))))
                    val calendarDay = Calendar.getInstance()
                    calendarDay.time = nextWeekDay
                    calendarDay.set(Calendar.HOUR_OF_DAY, dto.dateMonth)
                    calendarDay.set(Calendar.MINUTE, dto.dateMinutes)
                    calendarDay.set(Calendar.MILLISECOND, 0)
                    calendarDay.add(Calendar.DAY_OF_YEAR, ( dayNumber * 7 ))

                    // save class
                    createSingleClass(discipline, calendarDay.time)
                }

                numberOfRepetitions--
                dayNumber++
            }
        }
    }

    override fun startClass(professor: Professor, classId: Int) {
        val disciplineClass = findClassById(classId)
        checkBelongsTo(disciplineClass, professor)

        // check if this class has already started
        if( disciplineClass.status != DisciplineClassStatus.CREATED  ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.CLASS_IS_ALREADY_STARTED))
        }

        // change discipline class status to STARTED
        disciplineClass.status = DisciplineClassStatus.STARTED
        classesRepo.save(disciplineClass)

        // gather all class attendants messaging tokens
        val usersTokenList = prepareClassAttendantsMessagingTokens(disciplineClass)

        // prepare message
        val msg = HashMap<String, String>()
        msg[EventKeyEnum.EVENT_TYPE.toString()] = EventTypeEnum.CLASS_ENDED.toString()
        msg[EventKeyEnum.BODY.toString()] = ""

        // multi cast message to class attendants
        messagingService.multiCastLabeledMessage(
                msg, EventLabelsEnum.CLASS_STARTED.toString(), usersTokenList)
    }

    private fun checkBelongsTo(disciplineClass: DisciplineClass, professor: Professor) {
        if( disciplineClass.professor?.id != professor.id  ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }
    }

    private fun findClassById(id: Int): DisciplineClass {
        val classOpt = classesRepo.findById(id)
        classOpt.orElseThrow { throw ResourceNotFoundException(
                Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE,
                        arrayOf(Translator.toLocale(MessageCodes.DISCIPLINE_CLASS)))) }
        return classOpt.get()
    }

    private fun prepareCalendar(day: Int, month: Int, year: Int, hours: Int = 0, mins: Int = 0): Calendar =
        GregorianCalendar(year, convertIntToCalendarMonth(month), day, hours, mins, 0)

    private fun createSingleClass(discipline: Discipline, targetDate: Date) {
        val now = Calendar.getInstance()
        val newClass = DisciplineClass(
                discipline = discipline,
                professor = discipline.professor,
                attendants = mutableListOf(),
                status = DisciplineClassStatus.CREATED,
                scheduledTo = targetDate,
                createdAt = now.time,
                updatedAt = now.time
        )

        classesRepo.save(newClass)
    }

    private fun convertWeekDayToDayOfWeek(weekDay: WeekDayEnum): DayOfWeek {
        return when ( weekDay ) {
            WeekDayEnum.SUNDAY -> {
                DayOfWeek.SUNDAY}
            WeekDayEnum.MONDAY -> {
                DayOfWeek.MONDAY}
            WeekDayEnum.TUESDAY -> {
                DayOfWeek.TUESDAY}
            WeekDayEnum.WEDNESDAY -> {
                DayOfWeek.WEDNESDAY}
            WeekDayEnum.THURSDAY -> {
                DayOfWeek.THURSDAY}
            WeekDayEnum.FRIDAY -> {
                DayOfWeek.FRIDAY}
            WeekDayEnum.SATURDAY -> {
                DayOfWeek.SATURDAY}
            else -> throw BadFormatException(Translator.toLocale(MessageCodes.BAD_FORMAT, arrayOf(Translator.toLocale(MessageCodes.WEEK_DAY))))
        }
    }

    private fun convertIntToCalendarMonth(month: Int): Int {
        return when( month ) {
            1 -> Calendar.JANUARY
            2 -> Calendar.FEBRUARY
            3 -> Calendar.MARCH
            4 -> Calendar.APRIL
            5 -> Calendar.MAY
            6 -> Calendar.JUNE
            7 -> Calendar.JULY
            8 -> Calendar.AUGUST
            9 -> Calendar.SEPTEMBER
            10 -> Calendar.OCTOBER
            11 -> Calendar.NOVEMBER
            12 -> Calendar.DECEMBER
            else -> Calendar.JANUARY
        }
    }

    private fun prepareClassAttendantsMessagingTokens(disciplineClass: DisciplineClass): ArrayList<String> {
        val result = ArrayList<String>()
        disciplineClass.attendants?.forEach { attendant ->
            attendant.student?.fcmToken.let {token ->
                result.add(token!!)
            }
        }
        return result
    }

}