package com.vf.business.business.dao.models

import com.vf.business.common.CountryCodeEnum
import java.util.Date
import javax.persistence.Entity
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
        active: Boolean = false,
        enabled: Boolean = true,
        createdAt: Date,
        updatedAt: Date
) : User(id, firstName, lastName, email, pwd, countryCode, fcmToken, active, enabled, createdAt, updatedAt)