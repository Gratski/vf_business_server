package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.repo.CategoryRepository
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.discipline.classes.VFClassDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.CategoryService
import com.vf.business.business.service.itf.ClassesService
import com.vf.business.business.service.itf.DisciplineService
import com.vf.business.business.utils.CategoryMapper
import com.vf.business.common.PeriodEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
        val categoryRepo: CategoryRepository,
        val disciplineService: DisciplineService,
        val classesService: ClassesService
        ): CategoryService {


    override fun getAllCategories(): Collection<CategoryDTO> {
        val categories = categoryRepo.findAll();
        val result = arrayListOf<CategoryDTO>()
        categories.forEach {
            it?.let {
                result.add(CategoryMapper.Mapper.map(it))
            }
        }
        return result
    }

    override fun getById(id: Int): CategoryDTO =
            CategoryMapper.Mapper.map(getSingleCategory(id))

    override fun getCategoryDiscipline(id: Int, page: Pageable): Collection<DisciplineDTO> =
        disciplineService.getDisciplinesByCategory(getSingleCategory(id), page)

    override fun getActiveClasses(id: Int, page: Int, size: Int): Page<VFClassDTO> =
            classesService.getActiveClassesByCategory(getSingleCategory(id), page, size)

    override fun getCategoryDisciplinesByPeriodOfDay(id: Int, period: PeriodEnum,
                                        page: Pageable): Page<DisciplineDTO> {
        val category = getSingleCategory(id)
        return disciplineService.getDisciplinesByCategoryAndPeriodOfDay(category, period, page)
    }

    private fun getSingleCategory(id: Int): Category {
        val catOpt = categoryRepo.findById(id)
        catOpt.orElseThrow {
            throw ResourceNotFoundException()
        }
        return catOpt.get()
    }


}