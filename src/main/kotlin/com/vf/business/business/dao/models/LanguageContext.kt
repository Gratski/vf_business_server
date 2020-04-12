package com.vf.business.business.dao.models.localization

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.professor.Professor
import com.vf.business.business.dao.models.discipline.Discipline
import com.vf.business.business.dao.models.professor.ProfessorDetails
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "language_context")
class LanguageContext (
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "professor_id")
        open var professor: Professor,

        @ManyToOne
        @JoinColumn(name = "language_id")
        open var language: Language,

        open var isNative: Boolean,

        @OneToMany(mappedBy = "languageContext")
        open var disciplines: MutableList<Discipline>,

        @OneToOne(mappedBy = "languageContext")
        open var professorDetails: ProfessorDetails,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(
        id,
        createdAt,
        updatedAt
) {
}