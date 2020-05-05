package com.vf.business.business.dto.notifications.push

import com.vf.business.business.dao.models.NotificationType

class NotificationPreferenceDTO (
        val id: Int,
        val type: NotificationType,
        val isActive: Boolean
)