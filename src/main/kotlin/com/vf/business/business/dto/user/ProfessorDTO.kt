package com.vf.business.business.dto.user

import java.util.Date

class ProfessorDTO(id: Int,
               firstName: String,
               lastName: String,
               email: String,
               pwd: String?,
               active: Boolean = false,
               enabled: Boolean = true,
               createdAt: Date,
               updatedAt: Date) : UserDTO(id, firstName, lastName, email, pwd, active, enabled, createdAt, updatedAt)