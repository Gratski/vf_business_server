package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.notifications.feed.ListItemFeedNotificationDTO
import com.vf.business.business.service.itf.internal.FeedNotificationService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping(name = "\${api.version}/notifications")
class NotificationController(
        val usersService: UsersService,
        val notificationService: FeedNotificationService
) {

    @Secured
    @GetMapping("/{id}")
    fun getNotificationById(principal: Principal, @PathVariable("id") id: Long)
            : ListItemFeedNotificationDTO {
        var user = usersService.getUser(principal)
        return notificationService.findSingleNotification(user, id)
    }

}