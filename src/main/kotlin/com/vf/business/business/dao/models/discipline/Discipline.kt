package com.vf.business.business.dao.models.discipline

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import java.util.*
import javax.persistence.*

@Entity @Table( name = "discipline" )
class Discipline (
        id: Int?,

        @ManyToOne
        open var category: Category?,

        @ManyToOne
        @JoinColumn(name = "professor")
        open var professor: Professor,

        open var designation: String?,
        open var description: String?,
        open var active: Boolean?,
        open var enabled: Boolean?,

        @OneToMany(fetch = FetchType.LAZY)
        open var repetitions: Collection<DisciplineRepetition>,

        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
)