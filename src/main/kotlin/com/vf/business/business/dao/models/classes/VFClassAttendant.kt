package com.vf.business.business.dao.models.classes

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Student
import java.util.*
import javax.persistence.Entity
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity @Table(name = "class_attendant")
class VFClassAttendant (
        id: Int?,

        @ManyToOne
        open var student: Student?,

        @ManyToOne
        open var vfClass: VFClass?,

        open var leftAt: Date?,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id, createdAt, updatedAt
){
}