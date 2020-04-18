package com.vf.business.business.dto.notifications.feed

import com.vf.business.business.dao.models.notification.ClassFeedNotificationType

data class ListItemFeedNotificationDisciplineClassDTO(
        val category: String,
        val discipline: String,
        val language: String,
        val notificationType: ClassFeedNotificationType
)