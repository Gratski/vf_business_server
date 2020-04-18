package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Conversation
import com.vf.business.business.dao.models.User
import com.vf.business.business.dao.repo.ConversationRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.conversation.ConversationListItemDTO
import com.vf.business.business.exception.UnexistingConversationException
import com.vf.business.business.service.itf.internal.ConversationService
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

//TODO: Move this service to an Isolated Micro Service
@Service
class ConversationServiceImpl(
        val conversationsRepo: ConversationRepository
): ConversationService {

    // TODO: Optimize query method
    override fun getUserConversations(user: User, page: Int, size: Int): ResourcePage<ConversationListItemDTO> {
        val pageRequest = PageRequest.of(page, size)
        val resultsPage = conversationsRepo.findUserConversationsOrderedByLastMessageDesc(user, pageRequest)
        val items = mutableListOf<ConversationListItemDTO>()
        resultsPage.forEach {
            try {
                val otherUser = extractOTherUserFromConversation(it, user)
                val lastMessage = it.messages[0]
                val lineItem = ConversationListItemDTO(
                        id = it.id!!,
                        otherId = otherUser.id!!,
                        otherUsername =  "${otherUser.firstName} ${otherUser.lastName}",
                        lastMessage = lastMessage.body,
                        lastMessageDate = lastMessage.createdAt,
                        lastMessageSeen = lastMessage.seen,
                        lastMessageSeenAt = lastMessage.seen_at
                )
                items.add(lineItem)
            } catch(e: UnexistingConversationException) {

            }
        }

        return ResourcePage<ConversationListItemDTO>(
                total = resultsPage.totalElements,
                items = items
        )
    }

    private fun extractOTherUserFromConversation(c: Conversation, u: User): User {
        c.correspondents?.forEach {
            if ( it.user.id != u.id ) {
                return it.user
            }
        }
        throw UnexistingConversationException()
    }

}