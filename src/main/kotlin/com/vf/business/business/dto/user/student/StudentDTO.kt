package com.vf.business.business.dto.user.student

import com.vf.business.business.dto.locatization.CountryDTO
import com.vf.business.business.dto.locatization.LanguageDTO
import com.vf.business.business.dto.user.Gender
import com.vf.business.business.dto.user.UserDTO
import java.util.Date

class StudentDTO(id: Int? = null,
                 firstName: String?,
                 lastName: String?,
                 email: String?,
                 birthday: Date?,
                 gender: Gender,
                 phoneNumber: String?,
                 pictureUrl: String? = null,
                 nationality: CountryDTO,
                 livingIn: CountryDTO,
                 spokenLanguages: MutableList<LanguageDTO>? = null,
                 pwd: String? = null,
                 active: Boolean? = false,
                 enabled: Boolean? = true,
                 createdAt: Date? = null,
                 updatedAt: Date? = null) : UserDTO(id, firstName, lastName, email, pwd, gender, birthday, phoneNumber, pictureUrl, nationality, livingIn, spokenLanguages, active, enabled, createdAt, updatedAt) {

    object ModelMapper { }

}