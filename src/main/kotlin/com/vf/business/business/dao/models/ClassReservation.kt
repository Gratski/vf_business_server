package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "class_reservation")
class ClassReservation (
        id: Int? = null,

        @ManyToOne
    @JoinColumn(name = "discipline_class")
    open var disciplineClass: DisciplineClass,

        @ManyToOne
    @JoinColumn(name = "student")
    open var student: Student,

        createdAt: Date?,
        updatedAt: Date?

): AbstractEntity(
id, createdAt, updatedAt
) {
}