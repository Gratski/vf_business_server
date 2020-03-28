package com.vf.business.dto.user

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.Date

open class UserDTO (
    @JsonProperty("id")
    val id: Int?,
    @JsonProperty("first_name")
    val firstName: String,
    @JsonProperty("last_name")
    val lastName: String,
    @JsonProperty("email")
    val email: String,
    @JsonProperty("pwd")
    val pwd: String?,
    @JsonProperty("active")
    val active: Boolean = false,
    @JsonProperty("enabled")
    val enabled: Boolean = true,
    @JsonProperty("created_at")
    val createdAt: Date,
    @JsonProperty("updated_at")
    val updatedAt: Date )