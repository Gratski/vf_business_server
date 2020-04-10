package com.vf.business.business.dao.models.discipline

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.classes.DisciplineClass
import java.util.*
import javax.persistence.*

@Entity @Table( name = "discipline_repetition" )
class DisciplineSlot(
        id: Int? = null,

        @ManyToOne
        open var discipline: Discipline,

        @ManyToOne
        open var professor: Professor,

        @Enumerated(EnumType.STRING)
        open var weekDay: WeekDayEnum,

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "disciplineSlot")
        open var classes: MutableCollection<DisciplineClass>?,

        open var startsAtHour: Int,
        open var startsAtMinutes: Int,
        open var enabled: Boolean,
        open var approved: Boolean,

        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity (
        id,
        createdAt,
        updatedAt
)