package com.vf.business.controller.authenticated

import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.classes.VFClassDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.service.itf.CategoryService
import com.vf.business.business.service.itf.ClassesService
import com.vf.business.common.PeriodEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("\${api.version}/categories")
class CategoryController (
        val categoryService: CategoryService
        ) {

    @GetMapping("")
    fun getAllCategories(): Collection<CategoryDTO> =
        categoryService.getAllCategories()

    @GetMapping("/{id}")
    fun getCategoryById(@PathVariable("id") id: Int ): CategoryDTO =
            categoryService.getById(id)

    @GetMapping("/{id}/disciplines/all")
    fun getAllCategoryDisciplines(
            @PathVariable("id") id: Int,
            pageable: Pageable
    ): CategoryDTO =
            categoryService.getById(id)

    /**
     * Gets a page of disciplines for the given category
     * Considering the period of day
     */
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