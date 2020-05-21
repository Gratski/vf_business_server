package com.vf.business.business.dao.models

import com.vf.business.business.dao.models.wallet.Wallet
import com.vf.business.business.dto.user.Gender
import com.vf.business.business.dto.user.student.StudentDTO
import com.vf.business.business.utils.mapper.CountryMapper
import java.util.Date
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "student")
class Student(
        id: Int? = null,
        referredBy: User? = null,
        referrals: MutableList<User>?,
        wallet: Wallet? = null,
        conversations: MutableList<ConversationCorrespondent>? = null,
        firstName: String?,
        lastName: String?,
        email: String?,
        pwd: String?,
        gender: Gender,
        birthday: Date,
        phoneNumberCountry: Country,
        phoneNumber: String? = null,
        nationality: Country,
        livingIn: Country,
        spokenLanguages: MutableList<UserLanguage>,

        notificationPreferences: MutableList<NotificationPreference>,

        fcmToken: String? = null,
        pwdToken: String? = null,
        pictureUrl: String? = null,

        @ManyToOne
        @JoinColumn(name = "currently_attending")
        open var currentlyAttending: DisciplineClass? = null,

        active: Boolean? = false,
        enabled: Boolean? = true,
        createdAt: Date,
        updatedAt: Date
) : User(id, referredBy, referrals, wallet, conversations, firstName, lastName, email, pwd, gender, birthday, phoneNumberCountry, phoneNumber, nationality, livingIn, spokenLanguages, notificationPreferences,  fcmToken, pwdToken, pictureUrl, active, enabled, createdAt, updatedAt) {

    object ModelMapper {
        fun from(student: Student): StudentDTO =
                StudentDTO(
                        id = student.id,
                        firstName = student.firstName,
                        lastName = student.lastName,
                        email = student.email,
                        birthday = student.birthday,
                        gender = student.gender,
                        phoneNumber = student.phoneNumber,
                        livingIn = CountryMapper.Mapper.map(student.livingIn!!),
                        nationality = CountryMapper.Mapper.map(student.nationality!!),
                        pwd = student.password,
                        active = student.active,
                        enabled = student.enabled,
                        createdAt = student.createdAt,
                        updatedAt = student.updatedAt)

    }

}