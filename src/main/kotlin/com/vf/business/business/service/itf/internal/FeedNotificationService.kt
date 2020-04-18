package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.User
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.notifications.feed.ListItemFeedNotificationDTO

interface FeedNotificationService {

    /**
     * Gets a page of notification of a given professor
     */
    fun findProfessorNotifications(professor: Professor, page: Int, size: Int): ResourcePage<ListItemFeedNotificationDTO>

    /**
     * Gets a single notification based on the given id
     */
    fun findSingleNotification(user: User, id: Long): ListItemFeedNotificationDTO

}