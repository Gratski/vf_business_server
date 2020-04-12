package com.vf.business.business.dao.models

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

        @OneToOne(mappedBy = "languageContext", cascade = [CascadeType.ALL])
        open var professorDetails: ProfessorDetails? = null,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(
        id,
        createdAt,
        updatedAt
) {
}