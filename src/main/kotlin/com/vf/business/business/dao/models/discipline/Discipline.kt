package com.vf.business.business.dao.models.discipline

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.discipline.classes.DisciplineClass
import com.vf.business.business.dao.repo.DisciplineClassesRepository
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

        @OneToMany(fetch = FetchType.LAZY, mappedBy = "discipline")
        open var classes: MutableCollection<DisciplineClass>?,

        open var designation: String?,
        open var description: String?,
        open var imageUrl: String?,
        open var duration: Int, //in minutes

        open var reviewsScore: Double? = -1.0,

        open var active: Boolean? = true,
        open var enabled: Boolean? = false,
        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
)