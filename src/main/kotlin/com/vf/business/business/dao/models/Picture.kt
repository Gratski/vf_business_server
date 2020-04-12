package com.vf.business.business.dao.models.documents

import com.vf.business.business.dao.models.AbstractEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity @Table( name = "picture" )
class Picture(
        id: Int?,
        open var designation: String?,
        open var extension: String?,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
)