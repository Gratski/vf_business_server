package com.vf.business.dto.user

import java.util.Date

class StudentDTO(id: Int,
                 firstName: String,
                 lastName: String,
                 email: String,
                 pwd: String?,
                 active: Boolean = false,
                 enabled: Boolean = true,
                 createdAt: Date?,
                 updatedAt: Date?) : UserDTO(id, firstName, lastName, email, pwd, active, enabled, createdAt, updatedAt)