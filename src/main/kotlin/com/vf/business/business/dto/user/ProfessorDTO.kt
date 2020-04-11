package com.vf.business.business.dto.user

import com.vf.business.common.CountryCodeEnum
import java.util.Date

class ProfessorDTO(id: Int?,
               firstName: String?,
               lastName: String?,
               email: String?,
               pwd: String? = null,
               countryCode: CountryCodeEnum? = null,
               active: Boolean? = false,
               enabled: Boolean? = true,
               createdAt: Date?,
               updatedAt: Date?) : UserDTO(id, firstName, lastName, email, pwd, countryCode, active, enabled, createdAt, updatedAt)