package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.discipline.Discipline
import com.vf.business.business.dao.repo.CategoryRepository
import com.vf.business.business.dao.repo.DisciplineRepository
import com.vf.business.business.dto.discipline.CreateDisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.UpdateDisciplineDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.exception.MissingArgumentsException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
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


@Service
class DisciplineServiceImpl(
        val storageService: StorageService,
        val disciplineRepo: DisciplineRepository,
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


    override fun getDiscipline(id: Int): DisciplineDTO {
        val disciplineOpt = disciplineRepo.findById(id)
        disciplineOpt.orElseThrow {
            throw ResourceNotFoundException()
        }
        return DisciplineMapper.Mapper.map(disciplineOpt.get())
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

        val disciplineOpt = disciplineRepo.findById(id)
        disciplineOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.DISCIPLINE))))
        }

        val discipline = disciplineOpt.get()

        // verify if the current user is the owner professor
        if( professor.id != discipline.professor.id ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }

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

    fun hasAllRequiredFields(dto: CreateDisciplineDTO): Boolean {
        return dto != null && dto.categoryId != null
                && dto.description != null && dto.description.isNotBlank()
                && dto.designation != null && dto.designation.isNotBlank()
                && dto.duration != null && dto.duration > 0
    }

    fun hasAllRequiredFields(dto: UpdateDisciplineDTO): Boolean {
        return dto != null && dto.categoryId != null
                && dto.description != null && dto.description.isNotBlank()
                && dto.designation != null && dto.designation.isNotBlank()
                && dto.duration != null && dto.duration > 0
    }
}