package com.vf.business.controller.authenticated

import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.service.itf.CategoryService
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.version}/category")
class CategoryController (val categoryService: CategoryService) {

    @GetMapping("")
    fun getAllCategories(): Collection<CategoryDTO> =
        categoryService.getAllCategories()

    @GetMapping("/{id}")
    fun getAllCategories(@PathVariable("id") id: Int ): CategoryDTO =
            categoryService.getById(id)

    @GetMapping("/{id}/disciplines")
    fun getCategoryClasses(
            @PathVariable("id") id: Int,
            pageable: Pageable
    ): CategoryDTO =
            categoryService.getById(id)

}