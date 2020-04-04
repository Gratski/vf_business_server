package com.vf.business.business.service.itf

import com.vf.business.business.dto.category.CategoryDTO

interface CategoryService {

    /**
     * Gets all available categories
     */
    fun getAllCategories(): Collection<CategoryDTO>

    /**
     * Gets a single Category based on its id
     */
    fun getById(id: Int): CategoryDTO

}