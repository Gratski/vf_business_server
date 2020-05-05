package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.User
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.notifications.NotificationTypeDTO
import com.vf.business.business.dto.notifications.push.NotificationPreferenceDTO
import com.vf.business.business.dto.user.UpdatedUserDetailsDTO
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
     * Updates an existing user
     */
    fun updateUser(user: User)

    /**
     * Updates a given user details
     */
    fun updateUserPersonalDetails(user: User, details: UpdatedUserDetailsDTO)

    /**
     * Soft delete user
     */
    fun deleteUser(id: Int)

    /**
     * Gets the notification preferences for a given user
     */
    fun getNotificationPreferences(user: User): ResourcePage<NotificationPreferenceDTO>

    /**
     * Enables/Disables the given type of notification for the given user
     */
    fun enableDisableNotification(user: User, notificationType: NotificationTypeDTO, isEnabled: Boolean)

}