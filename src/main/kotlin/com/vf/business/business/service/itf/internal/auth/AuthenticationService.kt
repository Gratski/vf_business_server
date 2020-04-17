package com.vf.business.business.service.itf.internal.auth

import com.vf.business.business.dao.models.User
import com.vf.business.business.dto.auth.AppDomainEnum
import com.vf.business.business.dto.auth.ChangePasswordDTO
import com.vf.business.business.dto.auth.ResetPasswordDTO
import com.vf.business.business.dto.auth.SignInResponseDTO

interface AuthenticationService {

    fun signin(email: String, password: String, domain: AppDomainEnum): SignInResponseDTO

    /**
     * Sends a token to set a new password to the given user email
     *
     * @throws ResourceNotFoundException if no user with the given email was found
     */
    fun passwordRecovery(email: String)

    /**
     * Resets the user password if the token mathces the user generated password reset token
     */
    fun resetPassword(dto: ResetPasswordDTO)

    /**
     * Changes the password of the given user if the oldPassword matches with the database one
     * @throws UnauthorizedOperationException if not
     */
    fun changePassword(user: User, dto: ChangePasswordDTO)

}