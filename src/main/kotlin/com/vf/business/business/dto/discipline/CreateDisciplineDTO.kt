package com.vf.business.business.dto.discipline

class CreateDisciplineDTO (
        val categoryId: Int,
        val languageContextId: Int,
        val designation: String,
        val description: String,
        val equipment: String,
        val goal: String,
        val calories: Double,
        val duration: Int,
        val maxAttendants: Int
)