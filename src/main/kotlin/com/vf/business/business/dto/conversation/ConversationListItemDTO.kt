package com.vf.business.business.dto.conversation

import java.util.*

data class ConversationListItemDTO(
    val id: Long,
    val otherUsername: String,
    val otherId: Int,
    val lastMessage: String,
    val lastMessageDate: Date,
    val lastMessageSeen: Boolean,
    val lastMessageSeenAt: Date? = null
)