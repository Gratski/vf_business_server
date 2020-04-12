package com.vf.business.business.dao.models

import com.vf.business.business.dao.models.discipline.classes.DisciplineClass
import com.vf.business.business.dto.user.StudentDTO
import com.vf.business.common.CountryCodeEnum
import java.util.Date
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "student")
class Student(
        id: Int? = null,
        firstName: String?,
        lastName: String?,
        email: String?,
        pwd: String?,
        countryCode: CountryCodeEnum?,
        fcmToken: String? = null,

        @ManyToOne
        @JoinColumn(name = "currently_attending")
        open var currentlyAttending: DisciplineClass? = null,

        active: Boolean? = false,
        enabled: Boolean? = true,
        createdAt: Date?,
        updatedAt: Date?
) : User(id, firstName, lastName, email, pwd, countryCode, fcmToken, active, enabled, createdAt, updatedAt) {

    object ModelMapper {
        fun from(dto: Student): StudentDTO =
                StudentDTO(
                        id = dto.id,
                        firstName = dto.firstName,
                        lastName = dto.lastName,
                        email = dto.email,
                        countryCode = dto.countryCode,
                        pwd = dto.password,
                        active = dto.active,
                        enabled = dto.enabled,
                        createdAt = dto.createdAt,
                        updatedAt = dto.updatedAt)

    }

}