package com.vf.business.business.dto.notifications.feed

import com.vf.business.business.dao.models.notification.ClassFeedNotificationType

data class ListItemFeedNotificationDisciplineClassDTO(
        val userName: String,
        val userCountryCode: String,
        val userPictureUrl: String?,
        val discipline: String,
        val disciplineLanguage: String,
        val notificationType: ClassFeedNotificationType
)