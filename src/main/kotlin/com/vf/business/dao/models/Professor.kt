package com.vf.business.dao.models

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
        active: Boolean = false,
        enabled: Boolean = true,
        createdAt: Date,
        updatedAt: Date
) : User(id, firstName, lastName, email, pwd, active, enabled, createdAt, updatedAt)