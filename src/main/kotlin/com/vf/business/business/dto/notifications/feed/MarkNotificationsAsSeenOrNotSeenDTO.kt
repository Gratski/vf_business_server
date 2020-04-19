package com.vf.business.business.dto.notifications.feed

data class MarkNotificationsAsSeenOrNotSeenDTO (
        val notifications: MutableList<SeenOrNotSeenNotificationDTO>
)