package com.vf.business.dao.models

import org.springframework.data.annotation.PersistenceConstructor
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "student")
class Student(
        id: Int? = null,
        firstName: String,
        lastName: String,
        email: String,
        pwd: String?,
        active: Boolean = false,
        enabled: Boolean = true,
        createdAt: Date,
        updatedAt: Date
) : User(id, firstName, lastName, email, pwd, active, enabled, createdAt, updatedAt)