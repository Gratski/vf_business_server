package com.vf.business.business.dto.user.professor

data class UpdateLanguageProfileDTO (
    val id: Int, // language context id
    val designation: String,
    val description: String,
    val quote: String
)