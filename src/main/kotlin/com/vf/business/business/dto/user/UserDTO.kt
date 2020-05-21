package com.vf.business.business.dto.user

import com.vf.business.business.dto.locatization.CountryDTO
import com.vf.business.business.dto.locatization.LanguageDTO
import java.util.Date

open class UserDTO (
        val id: Int?,
        val firstName: String?,
        val lastName: String?,
        val email: String?,
        val pwd: String?,
        val gender: Gender,
        val birthday: Date?,
        val phoneNumber: String?,
        val pictureUrl: String?,
        val nationality: CountryDTO,
        val livingIn: CountryDTO,
        val spokenLanguages: MutableList<LanguageDTO>? = null,
        val active: Boolean? = false,
        val enabled: Boolean? = true,
        val createdAt: Date?,
        val updatedAt: Date? )