package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "country")
class Country (
        id: Int? = null,
        open var countryCode: String,
        open var countryName: String,

        @OneToMany(mappedBy = "country")
        open var spokenLanguages: MutableList<LanguageCountry>,


        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt){
}