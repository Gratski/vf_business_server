package com.vf.business.dto.user

import com.vf.business.dao.models.Student
import java.util.Date

class StudentDTO(id: Int? = null,
                 firstName: String?,
                 lastName: String?,
                 email: String?,
                 pwd: String? = null,
                 active: Boolean? = false,
                 enabled: Boolean? = true,
                 createdAt: Date? = null,
                 updatedAt: Date? = null) : UserDTO(id, firstName, lastName, email, pwd, active, enabled, createdAt, updatedAt) {

    object ModelMapper {
        fun from(dto: StudentDTO): Student =
            Student(
                id = dto.id,
                firstName = dto.firstName,
                lastName = dto.lastName,
                email = dto.email,
                pwd = dto.pwd,
                active = dto.active,
                enabled = dto.enabled,
                createdAt = dto.createdAt,
                updatedAt = dto.updatedAt)

        }
}