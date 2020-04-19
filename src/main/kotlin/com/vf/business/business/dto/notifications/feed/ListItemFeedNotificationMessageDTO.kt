package com.vf.business.business.dto.notifications.feed

data class ListItemFeedNotificationMessageDTO (
        val conversationId: Number,
        val fromId: Int,
        val fromName: String,
        val fromPictureUrl: String?,
        val body: String,
        val fromCountry: String
)