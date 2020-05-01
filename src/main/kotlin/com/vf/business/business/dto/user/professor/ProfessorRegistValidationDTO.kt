package com.vf.business.business.dto.user.professor

data class ProfessorRegistValidationDTO(
        val email: String,
        val password: String,
        val accessCode: String
)