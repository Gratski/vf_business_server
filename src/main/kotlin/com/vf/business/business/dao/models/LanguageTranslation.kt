package com.vf.business.business.dao.models

import javax.persistence.*

@Entity
@Table(name = "language_translation")
class LanguageTranslation(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        open var id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "language_id")
        open var language: Language,

        open var code: String,

        open var designation: String
) {
}