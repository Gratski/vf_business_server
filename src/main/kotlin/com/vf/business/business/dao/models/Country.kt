package com.vf.business.business.dao.models.localization

import com.vf.business.business.dao.models.AbstractEntity
import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "country")
class Country (
        id: Int? = null,
        open var countryCode: String,
        open var countryName: String,

        @OneToMany(mappedBy = "country")
        open var spokenLanguages: MutableList<LanguageCountry>,


        createdAt: Date? = null,
        updatedAt: Date? = null
): AbstractEntity(id, createdAt, updatedAt){
}