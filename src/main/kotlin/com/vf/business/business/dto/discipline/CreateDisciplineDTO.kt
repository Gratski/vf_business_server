package com.vf.business.business.dto.discipline

class CreateDisciplineDTO (
        val categoryId: Int,
        val designation: String,
        val description: String,
        val duration: Int,
        val maxAttendants: Int
)