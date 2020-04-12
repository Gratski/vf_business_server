package com.vf.business.business.dao.models

import com.vf.business.business.dao.models.discipline.classes.DisciplineClass
import com.vf.business.common.CountryCodeEnum
import java.util.Date
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "professor")
class Professor(
        id: Int?,
        firstName: String,
        lastName: String,
        email: String,
        pwd: String?,
        countryCode: CountryCodeEnum?,
        fcmToken: String? = null,
        pictureUrl: String?,

        @ManyToOne
        @JoinColumn(name = "currently_giving")
        open var currentlyGiving: DisciplineClass? = null,

        active: Boolean = false,
        enabled: Boolean = true,
        createdAt: Date,
        updatedAt: Date
) : User(id, firstName, lastName, email, pwd, countryCode, fcmToken, pictureUrl, active, enabled, createdAt, updatedAt)