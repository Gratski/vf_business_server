package com.vf.business.controller.permitted

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dto.auth.PasswordRecoveryDTO
import com.vf.business.business.dto.auth.ResetPasswordDTO
import com.vf.business.business.dto.auth.SignInRequestDTO
import com.vf.business.business.dto.auth.SignInResponseDTO
import com.vf.business.business.dto.user.UserDTO
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.auth.AuthenticationService
import com.vf.business.business.utils.mapper.ProfessorMapper
import com.vf.business.business.utils.mapper.StudentMapper
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/auth")
class AuthController (
        private val authService: AuthenticationService,
        private val usersService: UsersService
        ) {

    @PostMapping("/signin")
    fun signIn(@RequestBody signInRequest: SignInRequestDTO): SignInResponseDTO =
            authService.signin(signInRequest.email, signInRequest.password, signInRequest.domain)

    @PostMapping("/password-recovery")
    fun passwordRecovery(@RequestBody dto: PasswordRecoveryDTO) =
            authService.passwordRecovery(dto.email)

    @PostMapping("/password-reset")
    fun resetPassword(@RequestBody dto: ResetPasswordDTO) =
            authService.resetPassword(dto)

    @GetMapping("/me")
    fun getAuthenticatedUser(principal: Principal): UserDTO {
        val user = usersService.getUser(principal)
        return if( user is Student )
            StudentMapper.Mapper.map(user as Student)
        else
            ProfessorMapper.Mapper.map(user as Professor)
    }

}