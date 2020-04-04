package com.vf.business.business.dao.models.discipline

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Professor
import java.util.*
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity @Table( name = "discipline_repetition" )
class DisciplineRepetition(
        id: Int?,

        @ManyToOne
        open var discipline: Discipline,

        @ManyToOne
        open var professor: Professor,

        open var startsAt: Date,
        open var endsAt: Date,
        open var enabled: Boolean,
        open var approved: Boolean,

        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity (
        id,
        createdAt,
        updatedAt
)