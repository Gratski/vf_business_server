package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.*

@Entity @Table(name = "class")
class DisciplineClass (
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "discipline")
        open var discipline: Discipline?,

        @ManyToOne
        @JoinColumn(name = "professor")
        open var professor: Professor?,

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "disciplineClass")
        open var attendants: MutableCollection<ClassAttendant>,

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.LAZY, mappedBy = "disciplineClass")
        open var reservations: Collection<ClassReservation>?,

        @Enumerated(EnumType.STRING)
        open var status: DisciplineClassStatus?,

        open var scheduledTo: Date,

        open var startedAt: Date? = null,
        open var endedAt: Date? = null,
        createdAt: Date?,
        updatedAt: Date?

): AbstractEntity(
        id, createdAt, updatedAt
) {
}