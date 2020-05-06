package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.CategoryTranslation
import com.vf.business.business.dao.models.Language
import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.repo.CategoryRepository
import com.vf.business.business.dao.repo.CategoryTranslationRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.discipline.classes.VFClassDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.CategoryService
import com.vf.business.business.service.itf.internal.ClassesService
import com.vf.business.business.service.itf.internal.DisciplineService
import com.vf.business.business.service.itf.internal.LanguageContextService
import com.vf.business.business.utils.mapper.CategoryMapper
import com.vf.business.common.PeriodEnum
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class CategoryServiceImpl(
        val categoryRepo: CategoryRepository,
        val categoryTranslationsRepo: CategoryTranslationRepository,
        val disciplineService: DisciplineService,
        val classesService: ClassesService,
        val languageService: LanguageContextService
): CategoryService {


    override fun getAllCategories(): ResourcePage<CategoryDTO> {
        val language = languageService.getLanguageByCode(Translator.getContextLocaleLanguageCode(LocaleContextHolder.getLocale()))
        val categories = categoryTranslationsRepo.findAllByLanguage(language);
        val result = arrayListOf<CategoryDTO>()
        categories.forEach {
            it?.let {
                result.add(CategoryMapper.Mapper.map(it))
            }
        }
        return ResourcePage(total = categories.size.toLong(), items = result)
    }

    override fun getSubCategories(id: Int): ResourcePage<CategoryDTO> {
        val language = languageService.getLanguageByCode(Translator.getContextLocaleLanguageCode(LocaleContextHolder.getLocale()))
        val categories = categoryTranslationsRepo.findByParentIdAndLanguage(id, language)
        val result = mutableListOf<CategoryDTO>()
        categories.forEach {
            result.add(CategoryMapper.Mapper.map(it))
        }
        return ResourcePage(total = categories.size.toLong(), items = result)
    }

    override fun getById(categoryId: Int): CategoryDTO {
        val language = languageService.getLanguageByCode(Translator.getContextLocaleLanguageCode(LocaleContextHolder.getLocale()))
        return CategoryMapper.Mapper.map(getSingleCategoryTranslation(categoryId, language))
    }

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

    private fun getSingleCategoryTranslation(categoryId: Int, language: Language): CategoryTranslation {
        val catOpt = categoryTranslationsRepo.findByCategoryIdAndLanguage(categoryId, language)
        catOpt.orElseThrow {
            throw ResourceNotFoundException()
        }
        return catOpt.get()
    }


}

