package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.ConversationCorrespondent
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ConversationCorrespondentRepository: CrudRepository<ConversationCorrespondent, Long> {
}