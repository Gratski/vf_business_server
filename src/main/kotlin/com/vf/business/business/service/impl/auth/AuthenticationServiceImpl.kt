package com.vf.business.business.service.impl.auth

import com.vf.business.business.dao.models.Admin
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dao.models.User
import com.vf.business.business.dao.repo.AccessCodeRepository
import com.vf.business.business.dao.repo.UsersRepository
import com.vf.business.business.dto.auth.AppDomainEnum
import com.vf.business.business.dto.auth.ChangePasswordDTO
import com.vf.business.business.dto.auth.ResetPasswordDTO
import com.vf.business.business.dto.auth.SignInResponseDTO
import com.vf.business.business.exception.BadFormatException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.internal.CommunicationsService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.auth.AuthenticationService
import com.vf.business.business.utils.auth.AuthUtils
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthenticationServiceImpl (
        private val userService: UsersService,
        private val tokenProvider: JwtTokenProvider,
        private val userRepo: UsersRepository,
        private val accessCodeRepo: AccessCodeRepository,
        private val communicationsService: CommunicationsService
) : AuthenticationService {


    override fun signin(email: String, password: String, domain: AppDomainEnum): SignInResponseDTO {
        val userOpt = userService.getUserByEmail(email)
        userOpt.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.AUTH_EMAIL_NOT_FOUND))
        }

        val user = userOpt.get()
        val hashedPassword = AuthUtils.Instance.hashPassword(password)
        if ( hashedPassword != null && hashedPassword != user.password) {
            throw BadCredentialsException(Translator.toLocale(MessageCodes.AUTH_INCORRECT_PASSWORD))
        }

        val roles = mutableListOf<String>()
        roles.add("ROLE_USER")

        // validate the user account domain against the request domain
        // add the correct role to the granted authorities
        if ( user is Student ) {

            if( domain != AppDomainEnum.STUDENTS_APP ) {
                throw BadCredentialsException(Translator.toLocale(MessageCodes.AUTH_UNAUTHORIZED_DOMAIN))
            }
            // add the correct role
            roles.add("ROLE_STUDENT")
        } else if ( user is Professor) {

            if( domain != AppDomainEnum.PROFESSORS_APP ) {
                throw BadCredentialsException(Translator.toLocale(MessageCodes.AUTH_UNAUTHORIZED_DOMAIN))
            }

            // validate profesor access code
            val accessCodeOpt = accessCodeRepo.findByEmail(user.email!!);
            accessCodeOpt.orElseThrow {
                throw BadCredentialsException(Translator.toLocale(MessageCodes.NO_ACCESS_CODE_FOUND))
            }
            val accessCode = accessCodeOpt.get()
            if ( !accessCode.confirmed ) {
                throw BadCredentialsException(Translator.toLocale(MessageCodes.ACCESS_CODE_NOT_CONFIRMED))
            }

            // add the correct role
            roles.add("ROLE_PROFESSOR")
        } else if ( user is Admin ) {
            roles.add("ROLE_ADMIN")
        }

        return SignInResponseDTO(user.id,
            tokenProvider.createToken("${user.id}", roles))
    }

    override fun passwordRecovery(email: String) {
        val user = getUserByEmail(email)

        // generate token
        val token = UUID.randomUUID().toString()
        user.pwdToken = token
        val newPass = AuthUtils.Instance.generateRandomString(10)
        user.password = AuthUtils.Instance.hashPassword(newPass)
        userRepo.save(user)

        // send email to user
        communicationsService.sendPasswordRecoveryEmail(user.email!!, user.firstName!!, newPass, LocaleContextHolder.getLocale().toLanguageTag())

    }

    override fun resetPassword(dto: ResetPasswordDTO) {
        val user = getUserByEmail(dto.email)

        // match given token with user pwd token
        if( user.pwdToken != dto.pwdToken ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }

        // clean user pwd token and change its password
        user.pwdToken = null
        user.password = AuthUtils.Instance.hashPassword(dto.newPassword)
        userRepo.save(user)
    }

    override fun changePassword(user: User, dto: ChangePasswordDTO) {
        // check the passwords match
        if ( user.password != AuthUtils.Instance.hashPassword(dto.oldPassword) ) {
            throw UnauthorizedOperationException(
                    Translator.toLocale(MessageCodes.CHANGE_PASSWORD_BAD_PASSWORD)
            )
        }

        // check if the new password format is ok
        if( dto.newPassword.isBlank() || dto.newPassword.length < 8 ) {
            throw BadFormatException(
                    Translator.toLocale(MessageCodes.PASSWORD_TOO_WEAK)
            )
        }

        // update the user with the new password
        user.password = AuthUtils.Instance.hashPassword(dto.newPassword)
        userRepo.save(user)
    }

    private fun getUserByEmail(email: String): User {
        val userOpt = userService.getUserByEmail(email)
        userOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.EMAIL)))
            )
        }
        return userOpt.get()
    }

}