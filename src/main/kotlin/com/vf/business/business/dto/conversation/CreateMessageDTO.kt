package com.vf.business.business.dto.conversation

data class CreateMessageDTO(
        val toUserId: Int,
        val body: String
)