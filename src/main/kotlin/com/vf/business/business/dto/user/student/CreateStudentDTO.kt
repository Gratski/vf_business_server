package com.vf.business.business.dto.user.student

import com.vf.business.business.dto.user.Gender
import java.util.*

data class CreateStudentDTO (
        val firstName: String,
        val lastName: String,
        val email: String,
        val nationality: Int,
        val livingIn: Int,
        val spokenLanguages: MutableList<Int>,
        val pwd: String,
        val gender: Gender,
        val birthday: Date,
        val phoneNumberCountryId: Int,
        val phoneNumber: String
)