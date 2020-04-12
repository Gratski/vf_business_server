package com.vf.business.business.dao.models

import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "professor")
class Professor(
        id: Int?,
        firstName: String,
        lastName: String,
        email: String,
        pwd: String?,
        nationality: Country,
        livingIn: Country,
        spokenLanguages: MutableList<UserLanguage>,

        @OneToMany(mappedBy = "professor")
        open var languageContexts: MutableList<LanguageContext>,

        @ManyToOne
        @JoinColumn(name = "currently_giving")
        open var currentlyGiving: DisciplineClass,

        @Column(name = "cancellations_number")
        open var cancellationsNumber: Int,

        fcmToken: String? = null,
        pictureUrl: String?,
        active: Boolean = false,
        enabled: Boolean = true,
        createdAt: Date,
        updatedAt: Date
) : User(id, firstName, lastName, email, pwd, nationality, livingIn, spokenLanguages, fcmToken, pictureUrl, active, enabled, createdAt, updatedAt) {
}