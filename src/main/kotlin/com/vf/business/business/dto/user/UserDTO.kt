package com.vf.business.business.dto.user

import com.vf.business.common.CountryCodeEnum
import java.util.Date

open class UserDTO (
        val id: Int?,
        val firstName: String?,
        val lastName: String?,
        val email: String?,
        val pwd: String?,
        val countryCode: CountryCodeEnum?,
        val active: Boolean? = false,
        val enabled: Boolean? = true,
        val createdAt: Date?,
        val updatedAt: Date? )