package com.vf.business.dto.user

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

open class UserDTO (
    val id: Int?,
    val firstName: String,
    val lastName: String,
    val email: String,
    val pwd: String?,
    val active: Boolean = false,
    val enabled: Boolean = true,
    val createdAt: Date?,
    val updatedAt: Date? )