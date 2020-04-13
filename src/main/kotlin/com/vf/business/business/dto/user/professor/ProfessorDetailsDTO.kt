package com.vf.business.business.dto.user.professor

data class ProfessorDetailsDTO (
        val designation: String,
        val description: String,
        val quote: String? = null
)