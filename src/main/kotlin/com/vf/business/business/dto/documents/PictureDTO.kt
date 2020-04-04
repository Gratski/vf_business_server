package com.vf.business.business.dto.documents

import com.vf.business.business.dto.AbstractDTO
import java.util.*

class PictureDTO (
        id: Int?,
        designation: String?,
        extension: String?,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractDTO(id, createdAt, updatedAt)