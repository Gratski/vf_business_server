package com.vf.business.business.service.itf.internal

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.discipline.classes.VFClassDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.common.PeriodEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

/**
 * Service that holds the category business logic
 */
interface CategoryService {

    /**
     * Gets all available categories
     */
    fun getAllCategories(): ResourcePage<CategoryDTO>

    /**
     * Get the sub categories of a given category
     */
    fun getSubCategories(id: Int): ResourcePage<CategoryDTO>

    /**
     * Gets a single Category based on its id
     */
    fun getById(id: Int): CategoryDTO

    /**
     * Gets a page of disciplines of a given category
     * It considers the page number and the page size
     */
    fun getCategoryDiscipline(id: Int, page: Pageable): Collection<DisciplineDTO>

    /**
     * Gets a page of active classes for a given category
     */
    fun getActiveClasses(id: Int, page: Int, size: Int): Page<VFClassDTO>

    /**
     * Gets a page of disciplines for a given category for a given period of day
     */
    fun getCategoryDisciplinesByPeriodOfDay(id: Int, period: PeriodEnum, page: Pageable): Page<DisciplineDTO>

}