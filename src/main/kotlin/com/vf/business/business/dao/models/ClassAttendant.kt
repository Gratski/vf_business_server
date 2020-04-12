package com.vf.business.business.dao.models.discipline.classes

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Student
import java.util.*
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity @Table(name = "class_attendant")
class ClassAttendant (
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "student")
        open var student: Student?,

        @ManyToOne
        @JoinColumn(name = "class")
        open var disciplineClass: DisciplineClass?,

        open var leftAt: Date? = null,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id, createdAt, updatedAt
){
}