package com.vf.business.business.dao.models.user

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.User
import com.vf.business.business.dao.models.localization.Language
import java.util.*
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "user_language")
class UserLanguage(
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "language_id")
        open var language: Language,

        @ManyToOne
        @JoinColumn(name = "app_user_id")
        open var user: User,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}