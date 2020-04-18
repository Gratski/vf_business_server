package com.vf.business.business.dto.notifications.feed

import java.util.*

data class ListItemFeedNotificationDTO (
    val id: Number,
    var type: FeedNotificationType? = null,
    var seen: Boolean = false,
    val date: Date,
    var pictureUrl: String? = null,
    var classObj: ListItemFeedNotificationDisciplineClassDTO? = null,
    var messageObj: ListItemFeedNotificationMessageDTO? = null,
    var systemObj: ListItemFeedNotificationSystemDTO? = null
)