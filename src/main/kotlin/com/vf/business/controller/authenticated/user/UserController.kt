package com.vf.business.controller.authenticated.user

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.auth.ChangePasswordDTO
import com.vf.business.business.dto.conversation.ConversationListItemDTO
import com.vf.business.business.service.itf.internal.ConversationService
import com.vf.business.business.service.itf.internal.ProfessorService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.auth.AuthenticationService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/users")
class UserController (
        val userService: UsersService,
        val authService: AuthenticationService,
        val conversationsService: ConversationService
) {

    @Secured
    @PostMapping("/me/change-password")
    fun changePassword(principal: Principal, @RequestBody dto: ChangePasswordDTO) {
        val user = userService.getUser(principal)
        authService.changePassword(user, dto)
    }

    @Secured
    @GetMapping("/me/conversations")
    fun getUserConversations(principal: Principal, @RequestParam("page") page: Int, @RequestParam("size") size: Int): ResourcePage<ConversationListItemDTO> {
        val user = userService.getUser(principal)
        return conversationsService.getUserConversations(user, page, size)
    }

}