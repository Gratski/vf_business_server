package com.vf.business.business.service.itf

import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.classes.VFClassDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.common.PeriodEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface CategoryService {

    /**
     * Gets all available categories
     */
    fun getAllCategories(): Collection<CategoryDTO>

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

}