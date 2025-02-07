package com.vf.business.controller.permitted

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dto.auth.*
import com.vf.business.business.dto.user.UserDTO
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.auth.AuthenticationService
import com.vf.business.business.utils.mapper.ProfessorMapper
import com.vf.business.business.utils.mapper.StudentMapper
import org.slf4j.LoggerFactory
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/auth")
class AuthController (
        private val authService: AuthenticationService,
        private val usersService: UsersService
        ) {

    val LOGGER = LoggerFactory.getLogger(AuthController::class.java)

    /**
     * Gets the authenticated user based on the given token
     */
    @Secured
    @GetMapping("/me")
    fun getAuthenticatedUser(principal: Principal): UserDTO {
        val user = usersService.getUser(principal)
        LOGGER.info("GET Authenticated user by ${user.email}")
        return if( user is Student )
            StudentMapper.Mapper.map(user as Student)
        else
            ProfessorMapper.Mapper.map(user as Professor)
    }

    /**
     * Signs in a user for a given domain
     */
    @PostMapping("/signin")
    fun signIn(@RequestBody signInRequest: SignInRequestDTO): SignInResponseDTO {
        LOGGER.info("Sign in attempt from ${signInRequest.email}")
        return authService.signin(signInRequest.email, signInRequest.password, signInRequest.domain)
    }

    /**
     * Triggers the password recover mechanisms
     */
    @PostMapping("/password-recovery")
    fun passwordRecovery(@RequestBody dto: PasswordRecoveryDTO) {
        LOGGER.info("Password Recovery by ${dto.email}")
        authService.passwordRecovery(dto.email)
    }

    /**
     * Resets the user password
     */
    @Secured
    @PostMapping("/password-reset")
    fun resetPassword(@RequestBody dto: ResetPasswordDTO) =
            authService.resetPassword(dto)

    @Secured
    @PostMapping("/me/change-password")
    fun changePassword(principal: Principal, @RequestBody dto: ChangePasswordDTO) {
        val user = usersService.getUser(principal)
        authService.changePassword(user, dto)
    }

}