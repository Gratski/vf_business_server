package com.vf.business.dao.models

import com.vf.business.dto.user.StudentDTO
import org.springframework.data.annotation.PersistenceConstructor
import java.util.Date
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "student")
class Student(
        id: Int? = null,
        firstName: String?,
        lastName: String?,
        email: String?,
        pwd: String?,
        active: Boolean? = false,
        enabled: Boolean? = true,
        createdAt: Date?,
        updatedAt: Date?
) : User(id, firstName, lastName, email, pwd, active, enabled, createdAt, updatedAt) {

    object ModelMapper {
        fun from(dto: Student): StudentDTO =
                StudentDTO(
                        id = dto.id,
                        firstName = dto.firstName,
                        lastName = dto.lastName,
                        email = dto.email,
                        pwd = dto.password,
                        active = dto.active,
                        enabled = dto.enabled,
                        createdAt = dto.createdAt,
                        updatedAt = dto.updatedAt)

    }

}