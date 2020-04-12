package com.vf.business.business.dto.locatization

data class CreateLanguageContextDTO (
        val languageId: Int,
        val isNative: Boolean,
        val professorDetails: CreateProfessorDetailsDTO
)