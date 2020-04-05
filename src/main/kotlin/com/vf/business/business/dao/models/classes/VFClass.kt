package com.vf.business.business.dao.models.classes

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.discipline.Discipline
import java.util.*
import javax.persistence.*

@Entity @Table(name = "class")
class VFClass (
        id: Int?,

        @ManyToOne
        open var discipline: Discipline?,

        @ManyToOne
        open var professor: Professor?,

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY)
        open var attendants: Collection<VFClassAttendant>?,

        open var startedAt: Date?,
        open var endedAt: Date?,
        createdAt: Date?,
        updatedAt: Date?

): AbstractEntity(
        id, createdAt, updatedAt
) {
}