package com.vf.business.controller.authenticated.user

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.ChangePictureResponseDTO
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.auth.ChangePasswordDTO
import com.vf.business.business.dto.conversation.ConversationListItemDTO
import com.vf.business.business.dto.notifications.NotificationTypeDTO
import com.vf.business.business.dto.notifications.push.NotificationPreferenceDTO
import com.vf.business.business.dto.user.UpdatedUserDetailsDTO
import com.vf.business.business.service.itf.internal.ConversationService
import com.vf.business.business.service.itf.internal.ProfessorService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.service.itf.internal.auth.AuthenticationService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/users")
class UserController (
        val userService: UsersService,
        val authService: AuthenticationService,
        val conversationsService: ConversationService
) {

    @Secured
    @GetMapping("/me/conversations")
    fun getUserConversations(principal: Principal, @RequestParam("page") page: Int, @RequestParam("size") size: Int): ResourcePage<ConversationListItemDTO> {
        val user = userService.getUser(principal)
        return conversationsService.getUserConversations(user, page, size)
    }

    @Secured
    @PutMapping("/me")
    fun updateUserDetails(principal: Principal, @RequestBody dto: UpdatedUserDetailsDTO) {
        val user = userService.getUser(principal)
        userService.updateUserPersonalDetails(user, dto)
    }

    @Secured
    @PostMapping("/me/picture")
    fun changeProfilePicture(principal: Principal, @RequestParam file: MultipartFile): ChangePictureResponseDTO {
        val user = userService.getUser(principal)
        return userService.changeProfilePicture(user, file)
    }

    @Secured
    @GetMapping("/me/notification-preferences")
    fun getNotificationPreferences(principal: Principal): ResourcePage<NotificationPreferenceDTO> {
        return userService.getNotificationPreferences(userService.getUser(principal))
    }

    /**
     * Unables the given notification type for a given professor
     */
    @Secured
    @PostMapping("/me/notification-preferences/{type}/enable")
    fun enableNotification(principal: Principal, @PathVariable("type") notificationType: NotificationTypeDTO) {
        userService.enableDisableNotification(userService.getUser(principal), notificationType, true)
    }

    /**
     * Disables the given notification type for a given professor
     */
    @PostMapping("/me/notification-preferences/{type}/disable")
    fun disableNotification(principal: Principal, @PathVariable("type") notificationType: NotificationTypeDTO) {
        userService.enableDisableNotification(userService.getUser(principal), notificationType, false)
    }

}