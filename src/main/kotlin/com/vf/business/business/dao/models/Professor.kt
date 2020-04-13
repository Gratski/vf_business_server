package com.vf.business.business.dao.models

import com.vf.business.business.dto.user.Gender
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "professor")
class Professor(
        id: Int? = null,
        firstName: String,
        lastName: String,
        email: String,
        pwd: String?,
        gender: Gender,
        birthday: Date,
        phoneNumberCountry: Country,
        phoneNumber: String? = null,
        nationality: Country,
        livingIn: Country,
        spokenLanguages: MutableList<UserLanguage>,

        @Column(name = "nif")
        open var VAT: String,

        @OneToMany(mappedBy = "professor")
        open var languageContexts: MutableList<LanguageContext>,

        @ManyToOne
        @JoinColumn(name = "currently_giving")
        open var currentlyGiving: DisciplineClass? = null,

        notificationPreferences: MutableList<NotificationPreference>,

        @Column(name = "cancellations_number")
        open var cancellationsNumber: Int,

        fcmToken: String? = null,
        pictureUrl: String? = null,
        active: Boolean = false,
        enabled: Boolean = true,
        createdAt: Date,
        updatedAt: Date
) : User(id, firstName, lastName, email, pwd, gender, birthday, phoneNumberCountry, phoneNumber, nationality, livingIn, spokenLanguages, notificationPreferences, fcmToken, pictureUrl, active, enabled, createdAt, updatedAt) {
}