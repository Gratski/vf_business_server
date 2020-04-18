package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Conversation
import com.vf.business.business.dao.models.ConversationCorrespondent
import com.vf.business.business.dao.models.ConversationMessage
import com.vf.business.business.dao.models.User
import com.vf.business.business.dao.repo.ConversationCorrespondentRepository
import com.vf.business.business.dao.repo.ConversationMessageRepository
import com.vf.business.business.dao.repo.ConversationRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.conversation.ConversationListItemDTO
import com.vf.business.business.dto.conversation.ConversationMessageListItemDTO
import com.vf.business.business.dto.conversation.CreateMessageDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.exception.ConversationException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.ConversationService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

//TODO: Move this service to an Isolated Micro Service
@Service
class ConversationServiceImpl(
        val conversationsRepo: ConversationRepository,
        val conversationCorrespondentRepo: ConversationCorrespondentRepository,
        val conversationMessageRepo: ConversationMessageRepository,
        val usersService: UsersService
): ConversationService {

    // TODO: Optimize query method
    override fun getUserConversations(user: User, page: Int, size: Int): ResourcePage<ConversationListItemDTO> {
        val pageRequest = PageRequest.of(page, size)
        val resultsPage = conversationsRepo.findUserConversationsOrderedByLastMessageDesc(user, pageRequest)
        val items = mutableListOf<ConversationListItemDTO>()
        resultsPage.forEach {
            try {
                val otherUser = extractOtherUserFromConversation(it, user)
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
            } catch(e: ConversationException) {

            }
        }

        return ResourcePage<ConversationListItemDTO>(
                total = resultsPage.totalElements,
                items = items
        )
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun addMessageToConversationWithCreationCapability(user: User, dto: CreateMessageDTO): CreateOperationResponseDTO {
        val otherOpt = usersService.getUser(dto.toUserId)
        otherOpt.orElseThrow {
            throw ConversationException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.USER))))
        }
        val other = otherOpt.get()

        // get the retrieved conversation otherwise create a new one and get it
        val conversationOpt = conversationsRepo.findByCorrespondents(user, otherOpt.get())
        val conversation = conversationOpt.orElseGet {
            val now = Date()
            val newConversation = Conversation(
                messages = mutableListOf(),
                correspondents = mutableListOf(),
                createdAt = now,
                updatedAt = now
            )
            conversationsRepo.save(newConversation)

            val u1 = ConversationCorrespondent(
                conversation = newConversation,
                user = other,
                createdAt = now,
                updatedAt = now
            )
            val u2 = ConversationCorrespondent(
                conversation = newConversation,
                user = user,
                createdAt = now,
                updatedAt = now
            )
            conversationCorrespondentRepo.saveAll(mutableListOf(u1, u2))
            newConversation
        }

        val now = Date()
        val message = ConversationMessage(
            body = dto.body,
            conversation = conversation,
            seen = false,
            seen_at = null,
            sender = user,
            createdAt = now,
            updatedAt = now
        )
        conversationMessageRepo.save(message)
        return CreateOperationResponseDTO(id = message.id!!)
    }

    override fun addMessageToExistingConversation(user: User, conversationId: Long, dto: CreateMessageDTO) {
        val conversation = getConversationById(conversationId)
        val now = Date()
        val message = ConversationMessage(
                body = dto.body,
                conversation = conversation,
                seen = false,
                seen_at = null,
                sender = user,
                createdAt = now,
                updatedAt = now
        )
        conversationMessageRepo.save(message)
    }

    override fun getConversationMessages(currentUser: User, conversationId: Long, page: Int, size: Int): ResourcePage<ConversationMessageListItemDTO> {
        val conversation = getConversationById(conversationId)
        val pageReq = PageRequest.of(page, size)
        val messagesPage = conversationMessageRepo.findByConversationOrderByCreatedAtDesc(conversation, pageReq)
        val resultsList = mutableListOf<ConversationMessageListItemDTO>()
        messagesPage.forEach {
            val cur = ConversationMessageListItemDTO(
                    id = it.id!!,
                    body = it.body,
                    fromId = it.sender.id!!,
                    fromName = "${it.sender.firstName} ${it.sender.lastName}",
                    fromPictureUrl = "${it.sender.pictureUrl}"
            )
            resultsList.add(cur)
        }
        return ResourcePage(
                total = messagesPage.totalElements,
                items = resultsList
        )
    }

    private fun extractOtherUserFromConversation(c: Conversation, u: User): User {
        c.correspondents?.forEach {
            if ( it.user.id != u.id ) {
                return it.user
            }
        }
        throw ConversationException()
    }

    private fun getConversationById(id: Long): Conversation {
        val conversationOpt = conversationsRepo.findById(id)
        conversationOpt.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.CONVERSATION))))
        }
        return conversationOpt.get()
    }

}