package com.vf.business.business.dto.discipline

import com.vf.business.business.dto.AbstractDTO
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.user.ProfessorDTO
import java.util.*

class DisciplineDTO(
        id: Int?,
        val category: CategoryDTO,
        val professor: ProfessorDTO,
        val designation: String?,
        val description: String?,
        val repetitions: MutableCollection<DisciplineRepetitionDTO>?,
        val enabled: Boolean?,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractDTO(
        id, createdAt, updatedAt
) {
}