package com.vf.business.business.dto.discipline

import com.vf.business.business.dto.AbstractDTO
import com.vf.business.business.dto.user.ProfessorDTO
import java.util.*

class DisciplineSlotDTO(
        id: Int?,
        val startsAtHour: Int?,
        val startsAtMinutes: Int?,
        val enabled: Boolean? = false,
        val approved: Boolean? = false,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractDTO(
        id, createdAt, updatedAt
)