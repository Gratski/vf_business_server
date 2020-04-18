package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.ConversationMessage
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ConversationMessageRepository: CrudRepository<ConversationMessage, Int> {
}