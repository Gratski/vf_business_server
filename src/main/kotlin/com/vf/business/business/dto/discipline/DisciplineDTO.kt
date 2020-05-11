package com.vf.business.business.dto.discipline

import com.vf.business.business.dto.AbstractDTO
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.user.ProfessorDTO
import java.util.Date

class DisciplineDTO(
        id: Int?,
        val rate: Double,
        val languageId: Int,
        val languageCode: String,
        val category: CategoryDTO,
        val parentCategory: CategoryDTO,
        val professor: ProfessorDTO,
        val designation: String,
        val description: String,
        val imageUrl: String?,
        val duration: Int,
        val equipment: String,
        val calories: Double,
        val goals: String,
        val difficultyLevel: Int,
        val enabled: Boolean,
        val status: Int,
        val isActive: Boolean,
        val instructorId: Int,
        val instructorName: String,
        val instructorRate: Double,
        val instructorPictureUrl: String?,
        createdAt: Date,
        updatedAt: Date
) : AbstractDTO(
        id, createdAt, updatedAt
) {
}