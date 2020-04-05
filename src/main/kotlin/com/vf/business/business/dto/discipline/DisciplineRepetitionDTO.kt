package com.vf.business.business.dto.discipline

import com.vf.business.business.dto.AbstractDTO
import com.vf.business.business.dto.user.ProfessorDTO
import java.util.*

class DisciplineRepetitionDTO(
        id: Int?,
        discipline: DisciplineDTO,
        professor: ProfessorDTO,
        startsAt: Date?,
        endsAt: Date?,
        enabled: Boolean? = false,
        approved: Boolean? = false,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractDTO(
        id, createdAt, updatedAt
)