package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "language")
class Language(
        id: Int? = null,

        @Column(name = "code", unique = true)
        open var code: String,

        @Column(name = "system_language")
        open var systemLanguage: Boolean,

        @OneToMany(mappedBy = "language")
        open var countriesSpeaking: MutableList<LanguageCountry>,

        @OneToMany(mappedBy = "language")
        open var usersSpeaking: MutableList<UserLanguage>,

        @OneToMany(mappedBy = "language")
        open var translations: MutableList<LanguageTranslation> = mutableListOf(),

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}