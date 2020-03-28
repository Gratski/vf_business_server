package com.vf.business.business.dto.user

import java.util.Date

open class UserDTO (
    val id: Int?,
    val firstName: String?,
    val lastName: String?,
    val email: String?,
    val pwd: String?,
    val active: Boolean? = false,
    val enabled: Boolean? = true,
    val createdAt: Date?,
    val updatedAt: Date? )