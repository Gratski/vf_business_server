package com.vf.business.business.dto.user

import java.util.*

data class UpdatedUserDetailsDTO (
        val firstName: String,
        val lastName: String,
        val gender: Gender,
        val nationalityCountryId: Int,
        val phoneNumber: String,
        val birthday: Date
        )