package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.discipline.Discipline
import com.vf.business.business.dao.models.discipline.DisciplineSlot
import com.vf.business.business.dao.repo.CategoryRepository
import com.vf.business.business.dao.repo.DisciplineClassesRepository
import com.vf.business.business.dao.repo.DisciplineRepository
import com.vf.business.business.dao.repo.DisciplineSlotRepository
import com.vf.business.business.dto.discipline.CreateDisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.UpdateDisciplineDTO
import com.vf.business.business.dto.discipline.slot.CreateDisciplineSlotDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.exception.*
import com.vf.business.business.service.itf.DisciplineClassesService
import com.vf.business.business.service.itf.DisciplineService
import com.vf.business.business.service.itf.StorageService
import com.vf.business.business.utils.DisciplineMapper
import com.vf.business.common.PeriodEnum
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.transaction.Transactional


@Service
class DisciplineServiceImpl(
        val storageService: StorageService,
        val disciplineRepo: DisciplineRepository,
        val disciplineSlotRepo: DisciplineSlotRepository,
        val disciplineClassesService: DisciplineClassesService,
        val categoryRepo: CategoryRepository,
        val translator: Translator
) : DisciplineService {

    // hour to consider when getting morning classes
    val MORNING_STARTS_AT = 6 // inclusive
    val MORNING_ENDS_AT = 13 // hours

    // hour to consider when getting afternoon classes
    val AFTERNOON_STARTS_AT = 13 // inclusive
    val AFTERNOON_ENDS_AT = 20 // hours

    // hour to consider when getting evening classes
    val EVENING_STARTS_AT = 20 // inclusive
    val EVENING_ENDS_AT = 7 // hours

    val STARTS_AT_HOUR_LABEL = "startsAtHour"
    val STARTS_AT_MINUTES_LABEL = "startsAtMinutes"


    override fun getDiscipline(id: Int): DisciplineDTO =
        DisciplineMapper.Mapper.map(getDisciplineById(id))


    override fun getDisciplinesByCategory(category: Category, page: Pageable): Collection<DisciplineDTO> {
        val page = disciplineRepo.findByCategory(category, page)
        val result = arrayListOf<DisciplineDTO>()
        page.forEach {
            result.add(DisciplineMapper.Mapper.map(it))
        }
        return result
    }

    override fun getDisciplinesByCategoryAndPeriodOfDay(category: Category, period: PeriodEnum, page: Pageable): Page<DisciplineDTO> {
        var periodStartsAt: Int
        var periodEndsAt: Int

        // assign the correct initial hour and duration
        // to the desired period of time
        when (period) {
            PeriodEnum.MORNING -> {
                periodStartsAt = MORNING_STARTS_AT
                periodEndsAt = MORNING_ENDS_AT
            }
            PeriodEnum.AFTERNOON -> {
                periodStartsAt = AFTERNOON_STARTS_AT
                periodEndsAt = AFTERNOON_ENDS_AT
            }
            PeriodEnum.EVENING -> {
                periodStartsAt = EVENING_STARTS_AT
                periodEndsAt = EVENING_ENDS_AT
            }
            else -> {
                throw IllegalArgumentException(Translator.toLocale(MessageCodes.INVALID_PERIOD_OF_DAY))
            }
        }

        // get current date with locale
        var now = Calendar.getInstance(LocaleContextHolder.getLocale())
        val today = GregorianCalendar(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                0,0, 0).time

        // fetch disciplines
        val resultsPage = disciplineRepo.findByCategoryAndPeriodOfTime(
                category, periodStartsAt, periodEndsAt, today, page)

        // prepare returning DTOs page
        val resultList = arrayListOf<DisciplineDTO>()

        resultsPage?.iterator()?.forEach {
            resultList.add(DisciplineMapper.Mapper.map(it))
        }

        return PageImpl<DisciplineDTO>(resultList, page, resultsPage.totalElements)

    }

    override fun createDiscipline(professor: Professor, newDiscipline: CreateDisciplineDTO): CreateOperationResponseDTO {
        if( !hasAllRequiredFields(newDiscipline) )
            throw MissingArgumentsException(Translator.toLocale(MessageCodes.MISSING_ARGUMENTS))

        val categoryOpt = categoryRepo.findById(newDiscipline.categoryId)
        categoryOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE,
                            arrayOf(Translator.toLocale(MessageCodes.CATEGORY))))
        }

        val now = Date()
        val discipline = Discipline(
            category = categoryOpt.get(),
            professor = professor,
            slots = mutableListOf(),
            designation = newDiscipline.designation,
            description = newDiscipline.description,
            imageUrl = null,
            duration = newDiscipline.duration,
            enabled = false,
            createdAt = now,
            updatedAt = now
        )

        disciplineRepo.save(discipline)
        return CreateOperationResponseDTO(discipline.id)
    }

    override fun enableDisable(id: Int, isEnabled: Boolean) {
        //TODO: implement validation to check if the current user can change this
        val dOpt = disciplineRepo.findById(id)
        dOpt.orElseThrow {
            throw ResourceNotFoundException()
        }
        val discipline = dOpt.get()
        discipline.enabled = isEnabled
        disciplineRepo.save(discipline)
    }

    override fun updateDiscipline(id: Int, dto: UpdateDisciplineDTO, professor: Professor) {
        if( !hasAllRequiredFields(dto) )
            throw MissingArgumentsException(Translator.toLocale(MessageCodes.MISSING_ARGUMENTS))

        val discipline = getDisciplineById(id)

        // check if this discipline belongs to the given professor
        checkBelongsTo(discipline, professor)

        val newCategoryOpt = categoryRepo.findById(dto.categoryId)
        newCategoryOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.CATEGORY))))
        }
        val newCategory = newCategoryOpt.get()

        discipline.category = newCategory
        discipline.designation = dto.designation
        discipline.description = dto.description
        discipline.duration = dto.duration
        disciplineRepo.save(discipline)

        // TODO: Create all classes depending on the repetition type

    }

    override fun changeDisciplinePicture(id: Int, professor: Professor, file: MultipartFile) {
        val disciplineOpt = disciplineRepo.findById(id)
        disciplineOpt.orElseThrow {
            throw ResourceNotFoundException("This discipline does not exists")
        }

        val discipline = disciplineOpt.get()
        if ( discipline.professor.id != professor.id ) {
            throw UnauthorizedOperationException("This operation is not permitted")
        }

        // upload image to AWS
        val storePictureResponse = storageService.storePicture(file)

        // change it on the database to point to the new link
        discipline.imageUrl = storePictureResponse.url
        disciplineRepo.save(discipline)
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun createDisciplineSlot(id: Int, professor: Professor, slotDto: CreateDisciplineSlotDTO): CreateOperationResponseDTO {
        checkRequiredFields(slotDto)
        val discipline = getDisciplineById(id)
        checkBelongsTo(discipline, professor)

        // check if there are no other slots that may cause a functional conflict
        val startsAtDate = Calendar.getInstance()
        startsAtDate.set(Calendar.DAY_OF_WEEK, slotDto.weekDay.value())
        startsAtDate.set(Calendar.HOUR_OF_DAY, slotDto.startsAtHour)
        startsAtDate.set(Calendar.MINUTE, slotDto.startsAtMinutes)
        startsAtDate.set(Calendar.MILLISECOND, 0)

        val endsAtDate = startsAtDate.clone() as Calendar
        endsAtDate.add(Calendar.MINUTE, discipline.duration!!)

        discipline.slots?.forEach {

            val innerStartsAtDate = Calendar.getInstance()
            innerStartsAtDate.set(Calendar.DAY_OF_WEEK, it.weekDay.value())
            innerStartsAtDate.set(Calendar.HOUR_OF_DAY, it.startsAtHour)
            innerStartsAtDate.set(Calendar.MINUTE, it.startsAtMinutes)
            innerStartsAtDate.set(Calendar.MILLISECOND, 0)

            val innerEndsAtDate = innerStartsAtDate.clone() as Calendar
            innerEndsAtDate.add(Calendar.MINUTE, discipline.duration!!)

            if (
                    innerStartsAtDate == startsAtDate && innerEndsAtDate == endsAtDate
                    || innerStartsAtDate.after(startsAtDate) && innerStartsAtDate.before(endsAtDate)
                    || innerEndsAtDate.after(startsAtDate) && innerEndsAtDate.before(endsAtDate)
            ) {
                throw ResourceConflictException(
                        Translator.toLocale(MessageCodes.DISCIPLINE_SLOT_CONFLICT)
                )
            }
        }

        val now = Calendar.getInstance()
        val slot = DisciplineSlot(
                discipline = discipline,
                professor = professor,
                weekDay = slotDto.weekDay,
                classes = mutableListOf(),
                startsAtHour = slotDto.startsAtHour,
                startsAtMinutes = slotDto.startsAtMinutes,
                enabled = false,
                approved = true,
                createdAt = now.time,
                updatedAt = now.time
        )

        disciplineSlotRepo.save(slot)

        // create classes in advance according to repetition type
        disciplineClassesService.createClassesUntil(slot, slotDto.repetition, slot.weekDay, slot.startsAtHour,
                slot.startsAtMinutes, discipline.duration!!, 30)

        return CreateOperationResponseDTO(slot.id)

    }

    // Aux methods
    /**
     * Gets a discipline based on the given ID
     * @throws ResourceNotFoundException if resource does not exist
     */
    private fun getDisciplineById(id: Int): Discipline {
        val disciplineOpt = disciplineRepo.findById(id)
        disciplineOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.DISCIPLINE))))
        }
        return disciplineOpt.get()
    }

    /**
     * Checks if the given discipline belongs to the given professor
     * @throws UnauthorizedOperationException if the given condition doesn't apply
     */
    private fun checkBelongsTo(d: Discipline, p: Professor) {
        if( p.id != d.professor.id ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }
    }

    private fun checkRequiredFields(slotDto: CreateDisciplineSlotDTO): Boolean {
        if ( slotDto == null || slotDto.repetition == null
                || slotDto.startsAtHour == null || slotDto.startsAtMinutes == null) {
            throw MissingArgumentsException(Translator.toLocale(MessageCodes.MISSING_ARGUMENTS))
        }

        if ( slotDto.startsAtHour <= 0 || slotDto.startsAtHour > 23 ) {
            throw BadFormatException(
                    Translator.toLocale(MessageCodes.BAD_FORMAT, arrayOf(STARTS_AT_HOUR_LABEL))
            )
        }

        if ( slotDto.startsAtMinutes < 0 || slotDto.startsAtMinutes > 59) {
            throw BadFormatException(
                    Translator.toLocale(MessageCodes.BAD_FORMAT, arrayOf(STARTS_AT_MINUTES_LABEL))
            )
        }

        return true
    }

    // VALIDATIONS
    private fun hasAllRequiredFields(dto: CreateDisciplineDTO): Boolean {
        return dto != null && dto.categoryId != null
                && dto.description != null && dto.description.isNotBlank()
                && dto.designation != null && dto.designation.isNotBlank()
                && dto.duration != null && dto.duration > 0
    }

    private fun hasAllRequiredFields(dto: UpdateDisciplineDTO): Boolean {
        return dto != null && dto.categoryId != null
                && dto.description != null && dto.description.isNotBlank()
                && dto.designation != null && dto.designation.isNotBlank()
                && dto.duration != null && dto.duration > 0
    }
}