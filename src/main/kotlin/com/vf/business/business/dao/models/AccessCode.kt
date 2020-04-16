package com.vf.business.business.dao.models
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "access_code")
class AccessCode(
        id: Int? = null,

        @Column(name = "code")
        open var code: String,

        @Column(name = "email")
        open var email: String,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {}