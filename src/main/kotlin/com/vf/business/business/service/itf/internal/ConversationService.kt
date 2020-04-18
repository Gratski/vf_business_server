package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.User
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.conversation.ConversationListItemDTO

interface ConversationService {

    /**
     * Gets a page of user conversations ordered by last message date
     */
    fun getUserConversations(user: User, page: Int, size: Int): ResourcePage<ConversationListItemDTO>

}