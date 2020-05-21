package com.vf.business.business.dto.user

import com.vf.business.business.dto.locatization.CountryDTO
import com.vf.business.business.dto.locatization.LanguageDTO
import java.util.Date

class ProfessorDTO(id: Int?,
               firstName: String?,
               lastName: String?,
               email: String?,
               pwd: String? = null,
               gender: Gender,
               birthday: Date? = null,
               phoneNumber: String?,
               pictureUrl: String? = null,
               nationality: CountryDTO,
               livingIn: CountryDTO,
               spokenLanguages: MutableList<LanguageDTO>? = null,
               active: Boolean? = false,
               enabled: Boolean? = true,
               createdAt: Date?,
               updatedAt: Date?) : UserDTO(id, firstName, lastName, email, pwd, gender, birthday, phoneNumber, pictureUrl, nationality, livingIn, spokenLanguages, active, enabled, createdAt, updatedAt)