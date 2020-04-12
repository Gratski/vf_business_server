package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "language")
class Language(
        id: Int? = null,

        open var languageName: String,

        @OneToMany(mappedBy = "language")
        open var countriesSpeaking: MutableList<LanguageCountry>,

        @OneToMany(mappedBy = "language")
        open var usersSpeaking: MutableList<UserLanguage>,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}