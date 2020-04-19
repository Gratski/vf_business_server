package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.User
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.notifications.feed.ListItemFeedNotificationDTO
import com.vf.business.business.dto.notifications.feed.MarkNotificationsAsSeenOrNotSeenDTO

interface FeedNotificationService {

    /**
     * Gets a page of notification of a given professor
     */
    fun findProfessorNotifications(professor: Professor, page: Int, size: Int): ResourcePage<ListItemFeedNotificationDTO>

    /**
     * Gets a single notification based on the given id
     */
    fun findSingleNotification(user: User, id: Long): ListItemFeedNotificationDTO

    /**
     * Marks the notification as seen or not seen depending on the dto inner object seen values
     */
    fun markNotificationsAsSeen(user: User, dto: MarkNotificationsAsSeenOrNotSeenDTO)

}