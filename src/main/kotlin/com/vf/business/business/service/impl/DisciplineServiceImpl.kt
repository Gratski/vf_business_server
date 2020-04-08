package com.vf.business.business.service.impl

import com.amazonaws.AmazonServiceException
import com.amazonaws.auth.AWSCredentials
import com.amazonaws.auth.BasicAWSCredentials
import com.amazonaws.regions.Regions
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.ObjectMetadata
import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.discipline.Discipline
import com.vf.business.business.dao.repo.CategoryRepository
import com.vf.business.business.dao.repo.DisciplineRepository
import com.vf.business.business.dto.discipline.CreateDisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.UpdateDisciplineDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.impl.aws.VFCredentialsProvider
import com.vf.business.business.service.itf.DisciplineService
import com.vf.business.business.service.itf.StorageService
import com.vf.business.business.utils.DisciplineMapper
import com.vf.business.common.PeriodEnum
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
        val categoryRepo: CategoryRepository
) : DisciplineService {

    // hour to consider when getting morning classes
    val MORNING_STARTS_AT = 6 // inclusive
    val MORNING_DURATION = 7 // hours

    // hour to consider when getting afternoon classes
    val AFTERNOON_STARTS_AT = 13 // inclusive
    val AFTERNOON_DURATION = 7 // hours

    // hour to consider when getting evening classes
    val EVENING_STARTS_AT = 20 // inclusive
    val EVENING_DURATION = 7 // hours


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
        var periodDuration: Int

        // assign the correct initial hour and duration
        // to the desired period of time
        when (period) {
            PeriodEnum.MORNING -> {
                periodStartsAt = MORNING_STARTS_AT
                periodDuration = MORNING_DURATION
            }
            PeriodEnum.AFTERNOON -> {
                periodStartsAt = AFTERNOON_STARTS_AT
                periodDuration = AFTERNOON_DURATION
            }
            PeriodEnum.EVENING -> {
                periodStartsAt = EVENING_STARTS_AT
                periodDuration = EVENING_DURATION
            }
            else -> {
                throw IllegalArgumentException("Missing period attribute")
            }
        }

        // calculate the time interval to be considered
        var now = Calendar.getInstance()
        val from = GregorianCalendar(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                now.get(periodStartsAt),0, 0).time

        val periodTimeUntil = GregorianCalendar(
                now.get(Calendar.YEAR),
                now.get(Calendar.MONTH),
                now.get(Calendar.DAY_OF_MONTH),
                now.get(periodStartsAt),0, 0)

        periodTimeUntil.add(Calendar.HOUR_OF_DAY, periodDuration)
        val until = periodTimeUntil.time

        // fetch disciplines
        val resultsPage = disciplineRepo.findByCategoryAndPeriodOfTime(
                category, from, until, page)

        // prepare returning DTOs page
        val resultList = arrayListOf<DisciplineDTO>()

        resultsPage?.iterator()?.forEach {
            resultList.add(DisciplineMapper.Mapper.map(it))
        }

        return PageImpl<DisciplineDTO>(resultList, page, resultsPage.totalElements)

    }

    override fun createDiscipline(professor: Professor, newDiscipline: CreateDisciplineDTO): CreateOperationResponseDTO {
        val categoryOpt = categoryRepo.findById(newDiscipline.categoryId)
        categoryOpt.orElseThrow {
            throw ResourceNotFoundException("The given category does not exist")
        }

        val now = Date()
        val discipline = Discipline(
            category = categoryOpt.get(),
            professor = professor,
            designation = newDiscipline.designation,
            description = newDiscipline.description,
            imageUrl = null,
            enabled = false,
            repetitions = arrayListOf(),
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
        val disciplineOpt = disciplineRepo.findById(id)
        disciplineOpt.orElseThrow {
            throw ResourceNotFoundException("The given discipline does not exist")
        }

        val discipline = disciplineOpt.get()

        // verify if the current user is the owner professor
        if( professor.id != discipline.professor.id ) {
            throw UnauthorizedOperationException("This user is not authorized to perform this operation")
        }

        val newCategoryOpt = categoryRepo.findById(dto.categoryId)
        newCategoryOpt.orElseThrow {
            throw ResourceNotFoundException("This category does not exists")
        }
        val newCategory = newCategoryOpt.get()

        discipline.category = newCategory
        discipline.designation = dto.designation
        discipline.description = dto.description

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

}