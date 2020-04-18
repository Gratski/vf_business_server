package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Conversation
import com.vf.business.business.dao.models.User
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ConversationRepository: CrudRepository<Conversation, Long> {

    @Query("SELECT DISTINCT c FROM Conversation c " +
            "WHERE EXISTS " +
            "(" +
            "   SELECT u FROM User u, ConversationCorrespondent cc " +
            "   WHERE u = :user AND cc.conversation = c" +
            ") ")
    fun findUserConversationsOrderedByLastMessageDesc(@Param("user") user: User, pageable: Pageable): Page<Conversation>

    @Query("SELECT c FROM Conversation c " +
            "WHERE :user IN (SELECT cc1.user, cc2.user FROM ConversationCorrespondent cc1, ConversationCorrespondent cc2 " +
            "                   WHERE cc1.conversation = c AND cc2.conversation = c AND cc1 != cc2 " +
            "                   AND (( cc1.user = :user AND cc2.user = :other ) OR ( cc2.user = :user AND cc1.user = :other ) )" +
            ")")
    fun findByCorrespondents(
            @Param("user") user: User,
            @Param("other") other: User
        ): Optional<Conversation>

}