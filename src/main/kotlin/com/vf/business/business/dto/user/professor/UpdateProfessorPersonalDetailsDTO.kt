package com.vf.business.business.dto.user.professor

import com.vf.business.business.dto.user.Gender
import java.util.Date

data class UpdateProfessorPersonalDetailsDTO (
        val firstName: String,
        val lastName: String,
        val gender: Gender,
        val birthday: Date,
        val nationalityCountryId: Int,
        val phoneNumberCountryId: Int,
        val phoneNumber: String,
        val VAT: String
)