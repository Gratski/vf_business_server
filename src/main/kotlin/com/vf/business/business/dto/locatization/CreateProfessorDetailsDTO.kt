package com.vf.business.business.dto.locatization

data class CreateProfessorDetailsDTO(
        val languageId: Int? = null,
        val designation: String,
        val description: String,
        val quote: String
)