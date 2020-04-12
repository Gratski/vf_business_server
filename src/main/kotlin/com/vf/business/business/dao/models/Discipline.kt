package com.vf.business.business.dao.models

import java.util.Date
import javax.persistence.*

@Entity @Table( name = "discipline" )
class Discipline (
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "category")
        open var category: Category?,

        @ManyToOne
        @JoinColumn(name = "language_context_id")
        open var languageContext: LanguageContext,

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "discipline")
        open var classes: MutableCollection<DisciplineClass>?,

        open var designation: String?,
        open var description: String?,
        open var imageUrl: String?,
        open var duration: Int, //in minutes
        open var maxAttendants: Int,

        open var reviewsScore: Double? = -1.0,

        open var active: Boolean? = true,
        open var enabled: Boolean? = false,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
)