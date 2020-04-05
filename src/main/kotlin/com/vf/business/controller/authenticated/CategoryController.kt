package com.vf.business.controller.authenticated

import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.classes.VFClassDTO
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

    @GetMapping("/{id}/disciplines")
    fun getCategoryDisciplines(
            @PathVariable("id") id: Int,
            pageable: Pageable
    ): CategoryDTO =
            categoryService.getById(id)

    /**
     * Gets a collection of active classes for the given category
     */
    @GetMapping("/{id}/classes")
    fun getActiveClasses(
            @PathVariable("id") id: Int,
            @RequestParam("page") page: Int,
            @RequestParam("size") size: Int): Page<VFClassDTO> =
            categoryService.getActiveClasses(id, page, size)

}