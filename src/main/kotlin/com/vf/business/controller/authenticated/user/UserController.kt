package com.vf.business.controller.authenticated.user

import com.vf.business.business.dto.auth.ChangePasswordDTO
import com.vf.business.business.service.itf.internal.ProfessorService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.auth.AuthenticationService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/users")
class UserController (
        val userService: UsersService,
        val authService: AuthenticationService
) {

    @Secured
    @PostMapping("/me/change-password")
    fun changePassword(principal: Principal, @RequestBody dto: ChangePasswordDTO) {
        val user = userService.getUser(principal)
        authService.changePassword(user, dto)
    }

}