package com.vf.business.business.dto.discipline

import com.vf.business.business.dto.AbstractDTO
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.user.ProfessorDTO
import java.util.*

class DisciplineDTO(
        id: Int?,
        category: CategoryDTO,
        professor: ProfessorDTO,
        designation: String?,
        description: String?,
        repetitions: MutableCollection<DisciplineRepetitionDTO>? = mutableListOf<DisciplineRepetitionDTO>(),
        enabled: Boolean?,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractDTO(
        id, createdAt, updatedAt
) {
}