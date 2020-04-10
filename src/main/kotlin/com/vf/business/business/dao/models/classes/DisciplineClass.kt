package com.vf.business.business.dao.models.classes

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.discipline.Discipline
import com.vf.business.business.dao.models.discipline.DisciplineClassStatus
import com.vf.business.business.dao.models.discipline.DisciplineSlot
import java.util.*
import javax.persistence.*

@Entity @Table(name = "class")
class DisciplineClass (
        id: Int?,

        @ManyToOne
        open var discipline: Discipline?,

        @ManyToOne
        open var professor: Professor?,

        @ManyToOne
        open val disciplineSlot: DisciplineSlot,

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        open var attendants: Collection<VFClassAttendant>?,

        @Enumerated(EnumType.STRING)
        open var status: DisciplineClassStatus?,

        open var scheduledToDay: Date, // date of this class but with hour and minutes and milliseconds to 0
        open var scheduledTo: Date, // the actual date of the class

        open var startedAt: Date?,
        open var endedAt: Date?,
        createdAt: Date?,
        updatedAt: Date?

): AbstractEntity(
        id, createdAt, updatedAt
) {
}