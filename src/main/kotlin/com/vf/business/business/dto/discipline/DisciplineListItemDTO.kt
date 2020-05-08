package com.vf.business.business.dto.discipline

data class DisciplineListItemDTO(
        val id: Int,
        val designation: String,
        val difficultyLevel: Int,
        val duration: Int,
        val isActive: Boolean,
        val languageCode: String,
        val pictureUrl: String?
)