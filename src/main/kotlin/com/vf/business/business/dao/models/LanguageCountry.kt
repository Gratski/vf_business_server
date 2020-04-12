package com.vf.business.business.dao.models

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.Country
import com.vf.business.business.dao.models.Language
import java.util.*
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "language_countries")
class LanguageCountry(
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "language_id")
        open var language: Language,

        @ManyToOne
        @JoinColumn(name = "country_id")
        open var country: Country,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {

}