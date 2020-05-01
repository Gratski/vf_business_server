package com.vf.business.business.dto.user.professor

import com.vf.business.business.dto.user.Gender
import java.util.*

data class RegistProfessorAccountDTO(
        val email: String,
        val firstName: String,
        val lastName: String,
        val gender: Gender,
        val birthday: Date,
        val phoneNumber: String,
        val phoneNumberCountryId: Int,
        val nationalityCountryId: Int,
        val currentlyLivingInCountryId: Int,
        val nativeSpeakingLanguage: String, // language code
        val vat: String,
        val fcmToken: String?, // Firebase Device Token
        val professorDetails: ProfessorDetailsDTO // the registration code given to the professor so he/she can regist,,,,,,
)