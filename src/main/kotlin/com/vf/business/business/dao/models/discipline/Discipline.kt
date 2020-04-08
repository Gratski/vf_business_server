package com.vf.business.business.dao.models.discipline

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import java.util.Date
import javax.persistence.*

@Entity @Table( name = "discipline" )
class Discipline (
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "category")
        open var category: Category?,

        @ManyToOne
        @JoinColumn(name = "professor")
        open var professor: Professor,

        open var designation: String?,
        open var description: String?,
        open var imageUrl: String?,
        open var active: Boolean? = true,
        open var enabled: Boolean? = false,

        @OneToMany(fetch = FetchType.EAGER, mappedBy = "discipline")
        open var repetitions: MutableCollection<DisciplineRepetition>?,

        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
)