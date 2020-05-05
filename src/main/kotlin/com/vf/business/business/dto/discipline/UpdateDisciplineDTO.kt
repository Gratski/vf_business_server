package com.vf.business.business.dto.discipline

data class UpdateDisciplineDTO (
        val categoryId: Int,
        val languageId: Int,
        val designation: String,
        val description: String,
        val equipment: String,
        val goal: String,
        val calories: Double,
        val duration: Int,
        val maxAttendants: Int = 1000000
)