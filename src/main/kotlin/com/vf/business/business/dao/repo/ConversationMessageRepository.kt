package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Conversation
import com.vf.business.business.dao.models.ConversationMessage
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ConversationMessageRepository: CrudRepository<ConversationMessage, Long> {

    fun findByConversationOrderByCreatedAtDesc(conversation: Conversation, pageReq: PageRequest): Page<ConversationMessage>
}