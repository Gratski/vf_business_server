package com.vf.business.business.dto.user.student

data class CreateStudentDTO (
        val firstName: String,
        val lastName: String,
        val email: String,
        val nationality: Int,
        val livingIn: Int,
        val spokenLanguages: MutableList<Int>,
        val pwd: String
)