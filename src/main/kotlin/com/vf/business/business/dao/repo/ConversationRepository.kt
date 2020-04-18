package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Conversation
import com.vf.business.business.dao.models.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface ConversationRepository: CrudRepository<Conversation, Int> {

    @Query("SELECT DISTINCT c FROM Conversation c " +
            "WHERE EXISTS " +
            "(" +
            "   SELECT u FROM User u, ConversationCorrespondent cc " +
            "   WHERE u = :user AND cc.conversation = c" +
            ") ")
    fun findUserConversationsOrderedByLastMessageDesc(@Param("user") user: User, pageable: Pageable): Page<Conversation>

}