package com.vf.business.business.dto.classes

import com.vf.business.business.dto.AbstractDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.user.ProfessorDTO
import java.util.*

class VFClassDTO (
        id: Int?,
        discipline: DisciplineDTO?,
        professor: ProfessorDTO?,
        startedAt: Date?,
        endedAt: Date?,
        createdAt: Date?,
        updatedAt: Date?
): AbstractDTO(
        id, createdAt, updatedAt
)