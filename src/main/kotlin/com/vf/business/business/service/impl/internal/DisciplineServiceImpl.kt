package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Discipline
import com.vf.business.business.dao.models.DisciplineStatus
import com.vf.business.business.dao.repo.CategoryRepository
import com.vf.business.business.dao.repo.CategoryTranslationRepository
import com.vf.business.business.dao.repo.DisciplineRepository
import com.vf.business.business.dao.repo.LanguageContextRepository
import com.vf.business.business.dto.discipline.CreateDisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.UpdateDisciplineDTO
import com.vf.business.business.dto.discipline.classes.CreateDisciplineClassesDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.exception.*
import com.vf.business.business.service.itf.internal.*
import com.vf.business.business.utils.mapper.DisciplineMapper
import com.vf.business.common.PeriodEnum
import com.vf.business.common.RepetitionTypeEnum
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
        val categoryTranslationRepo: CategoryTranslationRepository,
        val disciplineRepo: DisciplineRepository,
        val disciplineClassesService: ClassesService,
        val categoryRepo: CategoryRepository,
        val languageContextRepo: LanguageContextRepository,
        val languageService: LanguageContextService
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

    val WEEKLY_NUMBER_OF_REPETITION = 4


    override fun getDiscipline(id: Int): DisciplineDTO {
        val discipline = getDisciplineById(id)
        val language = languageService.getLanguageByCode(Translator.getContextLocaleLanguageCode(LocaleContextHolder.getLocale()))
        val subCategoryTranslation = categoryTranslationRepo.findByCategoryIdAndLanguage(discipline.category?.id!!, language)
        val parentCategoryTranslation = categoryTranslationRepo.findByCategoryIdAndLanguage(discipline.category?.parent?.id!!, language)
        subCategoryTranslation.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.DISCIPLINE))))
        }
        parentCategoryTranslation.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.DISCIPLINE))))
        }
        return DisciplineMapper.Mapper.map(discipline, ct = subCategoryTranslation.get(), ctParent = parentCategoryTranslation.get())
    }


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
        val now = Calendar.getInstance(LocaleContextHolder.getLocale())
        val from = GregorianCalendar(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                periodStartsAt,0, 0).time

        val until = GregorianCalendar(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                periodEndsAt,0, 0).time

        // fetch disciplines
        val resultsPage = disciplineRepo.findByCategoryAndPeriodOfTime(
                category, from, until, page)

        // prepare returning DTOs page
        val resultList = arrayListOf<DisciplineDTO>()

        resultsPage?.iterator()?.forEach {
            resultList.add(DisciplineMapper.Mapper.map(it, null, null))
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

        val languageContextOpt = languageContextRepo.findByLanguageIdAndProfessor(newDiscipline.languageId, professor)
        languageContextOpt.orElseThrow{
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE,
                    arrayOf(Translator.toLocale(MessageCodes.LANGUAGE_CONTEXT)))
            )
        }

        val now = Date()
        val discipline = Discipline(
                category = categoryOpt.get(),
                languageContext = languageContextOpt.get(),
                classes = mutableListOf(),
                maxAttendants = newDiscipline.maxAttendants,
                designation = newDiscipline.designation,
                description = newDiscipline.description,
                equipment = newDiscipline.equipment,
                goal = newDiscipline.goal,
                difficultyLevel = newDiscipline.difficultyLevel,
                calories = newDiscipline.calories,
                imageUrl = null,
                duration = newDiscipline.duration,
                enabled = false,
                createdAt = now,
                updatedAt = now,
                status = DisciplineStatus.WAITING_FOR_APPROVAL.status
        )

        disciplineRepo.save(discipline)
        return CreateOperationResponseDTO(discipline.id!!)
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
        discipline.equipment = dto.equipment
        discipline.calories = dto.calories
        discipline.goal = dto.goal
        discipline.difficultyLevel = dto.difficultyLevel
        discipline.maxAttendants = dto.maxAttendants
        disciplineRepo.save(discipline)
    }

    override fun changeDisciplinePicture(id: Int, professor: Professor, file: MultipartFile) {
        val disciplineOpt = disciplineRepo.findById(id)
        disciplineOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.DISCIPLINE)))
            )
        }

        val discipline = disciplineOpt.get()
        if ( discipline.languageContext.professor.id != professor.id ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }

        // store new picture
        val storePictureResponse = storageService.storePicture(file)

        // delete the old one
        if ( discipline.imageUrl != null ) {
            storageService.removePicture(discipline.imageUrl)
        }

        // change it on the database to point to the new link
        discipline.imageUrl = storePictureResponse.url
        disciplineRepo.save(discipline)
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun createDisciplineClasses(id: Int, professor: Professor, dto: CreateDisciplineClassesDTO) {
        hasAllRequiredFields(dto)
        val discipline = getDisciplineById(id)
        checkBelongsTo(discipline, professor)

        disciplineClassesService.createClassesFromUntil(dto, discipline)
    }

    override fun deleteDiscipline(professor: Professor, id: Int) {
        val discipline = getDisciplineById(id)
        checkBelongsTo(discipline, professor)

        discipline.active = false;
        disciplineRepo.save(discipline)
    }

    // Aux methods
    /**
     * Gets a discipline based on the given ID
     * @throws ResourceNotFoundException if resource does not exist
     */
    private fun getDisciplineById(id: Int): Discipline {
        val disciplineOpt = disciplineRepo.findById(id)
        if ( !disciplineOpt.isPresent || !disciplineOpt.get().active!! ) {
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
        if( p.id != d.languageContext.professor.id ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }
    }

    // VALIDATIONS
    private fun hasAllRequiredFields(dto: CreateDisciplineDTO): Boolean {
        return dto != null && dto.categoryId != null
                && dto.description != null && dto.description.isNotBlank()
                && dto.designation != null && dto.designation.isNotBlank()
                && dto.duration != null && dto.duration > 0
                && dto.calories != null && dto.calories > 0
                && dto.goal != null && dto.goal.isNotBlank()
                && dto.equipment != null && dto.equipment.isNotBlank()
    }

    private fun hasAllRequiredFields(dto: UpdateDisciplineDTO): Boolean {
        return dto != null && dto.categoryId != null
                && dto.description != null && dto.description.isNotBlank()
                && dto.designation != null && dto.designation.isNotBlank()
                && dto.duration != null && dto.duration > 0
                && dto.calories != null && dto.calories > 0
                && dto.goal != null && dto.goal.isNotBlank()
                && dto.equipment != null && dto.equipment.isNotBlank()
    }

    private fun hasAllRequiredFields(dto: CreateDisciplineClassesDTO): Boolean {
        if ( dto == null || dto.dateDay == null || dto.dateMonth == null || dto.dateYear == null
                || dto.repetition == null
                || ( dto.repetition != RepetitionTypeEnum.NONE && dto.numberOfRepetitions == null )
                || dto.dateHour == null || dto.dateMinutes == null) {
            throw MissingArgumentsException(Translator.toLocale(MessageCodes.MISSING_ARGUMENTS))
        }
        return true
    }
}