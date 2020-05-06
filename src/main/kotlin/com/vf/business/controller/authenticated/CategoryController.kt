package com.vf.business.controller.authenticated

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.discipline.classes.VFClassDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.service.itf.internal.CategoryService
import com.vf.business.common.PeriodEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${api.version}/categories")
class CategoryController (
        val categoryService: CategoryService
        ) {

    /**
     * Gets all existing categories
     */
    @Secured
    @GetMapping("")
    fun getAllCategories(): ResourcePage<CategoryDTO> =
        categoryService.getAllCategories()

    /**
     * Gets a single category based on the given ID
     */
    @Secured
    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable("id") id: Int ): CategoryDTO =
            categoryService.getById(id)

    /**
     * Gets a single category based on the given ID
     */
    @Secured
    @GetMapping("/{id}/sub-categories")
    fun getSubCategories(@PathVariable("id") id: Int ): ResourcePage<CategoryDTO> =
            categoryService.getSubCategories(id)

    /**
     * Gets a page of disciplines of a given category
     */
    @Secured
    @GetMapping("/{id}/disciplines")
    fun getAllCategoryDisciplines(
            @PathVariable("id") id: Int,
            pageable: Pageable
    ): CategoryDTO =
            categoryService.getById(id)

    /**
     * Gets a page of disciplines for the given category
     * Considering the period of day
     */
    @Secured
    @GetMapping("/{id}/disciplines/byPeriod")
    fun getCategoryDisciplinesByPeriodOfDay(
            @PathVariable("id") id: Int,
            @RequestParam("period") period: PeriodEnum,
            page: Pageable): Page<DisciplineDTO> =
            categoryService.getCategoryDisciplinesByPeriodOfDay(id, period, page)

    /**
     * Gets a page of active classes for the given category
     */
    @GetMapping("/{id}/classes")
    fun getActiveClasses(
            @PathVariable("id") id: Int,
            @RequestParam("page") page: Int,
            @RequestParam("size") size: Int): Page<VFClassDTO> =
            categoryService.getActiveClasses(id, page, size)

}