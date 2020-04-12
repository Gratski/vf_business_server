package com.vf.business.business.service.impl.auth

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dto.auth.AppDomainEnum
import com.vf.business.business.dto.auth.SignInResponseDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.auth.AuthenticationService
import com.vf.business.business.utils.auth.AuthUtils
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.stereotype.Service


@Service
class AuthenticationServiceImpl (
        private val userService: UsersService,
        private val tokenProvider: JwtTokenProvider
) : AuthenticationService {

    private val SALT = "GRATSKI"

    override fun signin(email: String, password: String, domain: AppDomainEnum): SignInResponseDTO {
        val userOpt = userService.getUserByEmail(email)
        userOpt.orElseThrow {
            throw ResourceNotFoundException("This email is not registered")
        }

        val user = userOpt.get()
        val hashedPassword = AuthUtils.Instance.hashPassword(password, SALT)
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
        } else if ( user is Professor ) {

            if( domain != AppDomainEnum.PROFESSORS_APP ) {
                throw BadCredentialsException("This account is not authorized for this Application")
            }
            // add the correct role
            roles.add("PROFESSOR")
        }

        return SignInResponseDTO(user.id,
            tokenProvider.createToken("${user.id}", roles))
    }

}