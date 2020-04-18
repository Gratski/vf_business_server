package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.User
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.conversation.ConversationListItemDTO
import com.vf.business.business.dto.conversation.ConversationMessageListItemDTO
import com.vf.business.business.dto.conversation.CreateMessageDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO

interface ConversationService {

    /**
     * Gets a page of user conversations ordered by last message date
     */
    fun getUserConversations(user: User, page: Int, size: Int): ResourcePage<ConversationListItemDTO>

    fun addMessageToConversationWithCreationCapability(user: User, dto: CreateMessageDTO): CreateOperationResponseDTO

    /**
     * Adds a message to an existing conversation
     *
     * @param user User sending the message
     * @param id Conversation id
     * @param dto DTO containing the message body
     */
    fun addMessageToExistingConversation(user: User, id: Int, dto: CreateMessageDTO)

    /**
     * Gets a page of messages of the given conversation
     */
    fun getConversationMessages(currentUser: User, conversationId: Int, page: Int, size: Int): ResourcePage<ConversationMessageListItemDTO>

}