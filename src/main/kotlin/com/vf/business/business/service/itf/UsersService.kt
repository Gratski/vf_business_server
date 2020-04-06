package com.vf.business.business.service.itf

import com.vf.business.business.dao.models.User
import java.security.Principal
import java.util.*

/**
 * Users Service Contract
 */
interface UsersService {

    /**
     * Gets a given user by id
     */
    fun getUser(id: Int): Optional<User>

    /**
     * Gets a given user by principal
     * Throws an BadCredentialsException if your does not exist
     */
    fun getUser(principal: Principal): User

    /**
     * Gets a given user by email
     */
    fun getUserByEmail(email: String): Optional<User>

    /**
     * Soft delete user
     */
    fun deleteUser(id: Int)

}