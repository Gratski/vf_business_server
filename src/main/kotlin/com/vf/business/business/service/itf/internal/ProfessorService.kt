package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.notifications.NotificationTypeDTO
import com.vf.business.business.dto.notifications.feed.ListItemFeedNotificationDTO
import com.vf.business.business.dto.user.professor.RegistProfessorAccountDTO
import com.vf.business.business.dto.user.professor.UpdateProfessorProfileDetailsDTO

interface ProfessorService {

    /**
     * Updates professor profile details
     */
    fun updateProfessorProfileDetails(professor: Professor, dto: UpdateProfessorProfileDetailsDTO)

    /**
     * Enables a notification type for the given professor
     */
    fun enableDisableNotification(professor: Professor, notificationType: NotificationTypeDTO, newValue: Boolean)

    /**
     * Creates a new professor account
     */
    fun registerNewProfessorAccount(dto: RegistProfessorAccountDTO)

    /**
     * Gets a page of notifications belonging to the given professor account
     */
    fun getProfessorNotifications(professor: Professor, page: Int, size: Int): ResourcePage<ListItemFeedNotificationDTO>

}