package com.vf.business.business.service.impl.auth

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dao.repo.UsersRepository
import com.vf.business.business.dto.auth.AppDomainEnum
import com.vf.business.business.dto.auth.SignInResponseDTO
import com.vf.business.business.exception.ResourceNotFoundException
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
        private val communicationsService: CommunicationsService
) : AuthenticationService {


    override fun signin(email: String, password: String, domain: AppDomainEnum): SignInResponseDTO {
        val userOpt = userService.getUserByEmail(email)
        userOpt.orElseThrow {
            throw ResourceNotFoundException("This email is not registered")
        }

        val user = userOpt.get()
        val hashedPassword = AuthUtils.Instance.hashPassword(password)
        if ( hashedPassword != null && hashedPassword != user.password) {
            throw BadCredentialsException("This email and password do not match")
        }

        val roles = mutableListOf<String>()
        roles.add("USER")

        // validate the user account domain against the request domain
        // add the correct role to the granted authorities
        if ( user is Student ) {

            if( domain != AppDomainEnum.STUDENTS_APP ) {
                throw BadCredentialsException("This account is not authorized for this Application")
            }
            // add the correct role
            roles.add("STUDENT")
        } else if ( user is Professor) {

            if( domain != AppDomainEnum.PROFESSORS_APP ) {
                throw BadCredentialsException("This account is not authorized for this Application")
            }
            // add the correct role
            roles.add("PROFESSOR")
        }

        return SignInResponseDTO(user.id,
            tokenProvider.createToken("${user.id}", roles))
    }

    override fun passwordRecovery(email: String) {
        val userOpt = userService.getUserByEmail(email)
        userOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.USER)))
            )
        }
        val user = userOpt.get()

        // generate token
        val token = UUID.randomUUID().toString()
        user.pwdToken = token
        userRepo.save(user)

        // send email to user
        communicationsService.sendPasswordRecoveryEmail(user.email!!, user.firstName!!, token, LocaleContextHolder.getLocale().toLanguageTag())

    }

}