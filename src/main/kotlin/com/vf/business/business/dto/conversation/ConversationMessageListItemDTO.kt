package com.vf.business.business.dto.conversation

data class ConversationMessageListItemDTO(
        val id: Int,
        val body: String,
        val fromId: Int,
        val fromName: String,
        val fromPictureUrl: String
)