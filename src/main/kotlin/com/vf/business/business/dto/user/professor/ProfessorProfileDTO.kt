package com.vf.business.business.dto.user.professor

import com.vf.business.business.dto.category.CategoryDTO

data class ProfessorProfileDTO (
        val id: Int,
        val firstName: String,
        val lastName: String,
        val pictureUrl: String?,
        val about: String?,
        val quote: String?,
        val teaches : MutableList<CategoryDTO>
)