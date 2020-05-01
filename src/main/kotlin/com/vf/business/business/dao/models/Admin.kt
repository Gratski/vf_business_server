package com.vf.business.business.dao.models

import com.vf.business.business.dto.user.Gender
import java.util.*
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "admin_user")
class Admin(
        id: Int? = null,
        firstName: String,
        lastName: String,
        email: String,
        pwd: String?,
        gender: Gender,
        birthday: Date,
        phoneNumberCountry: Country,
        phoneNumber: String? = null,
        active: Boolean = true,
        enabled: Boolean = true,
        createdAt: Date,
        updatedAt: Date
): User(id, null, null, null, null, firstName, lastName, email, pwd, gender, birthday, phoneNumberCountry, phoneNumber, null, null, arrayListOf(), arrayListOf(), null, null, null, active, enabled, createdAt, updatedAt);