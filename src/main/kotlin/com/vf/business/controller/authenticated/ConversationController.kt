package com.vf.business.controller.authenticated

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.conversation.ConversationMessageListItemDTO
import com.vf.business.business.dto.conversation.CreateMessageDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.service.itf.internal.ConversationService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/conversations")
class ConversationController(
        val conversationsService: ConversationService,
        val usersService: UsersService
) {

    /**
     * Sends a message with the capability of identifying an existing conversation
     * Between two users. If this conversation exists the given CreateMessageDTO is added to it.
     * If not, then a new conversation is created between the two users and then the message is added to
     * the conversation.
     *
     * NOTE: This is specially useful when a message has to be exchanged without knowing if there is a conversation
     * between the two users.
     *
     * @return a DTO containing the conversation id
     */
    @PostMapping("/sendMessage")
    fun addMessageWithConversationCreationCapability(principal: Principal, @RequestBody dto: CreateMessageDTO): CreateOperationResponseDTO {
        val user = usersService.getUser(principal)
        return conversationsService.addMessageToConversationWithCreationCapability(user, dto)
    }

    /**
     * Sends a message to an existing conversation based on the given params
     */
    @Secured
    @PostMapping("/{id}/messages")
    fun addMessageToExistingConversation(principal: Principal, @PathVariable("id") id: Long, @RequestBody dto: CreateMessageDTO) {
        val user = usersService.getUser(principal)
        return conversationsService.addMessageToExistingConversation(user, id, dto)
    }

    /**
     * Gets a page of messages for the given conversation sorted by id DESC
     */
    @Secured
    @GetMapping("/{id}/messages")
    fun getConversationMessages(principal: Principal, @PathVariable("id") id: Long, @RequestParam("page") page: Int, @RequestParam("size") size: Int): ResourcePage<ConversationMessageListItemDTO> {
        val user = usersService.getUser(principal)
        return conversationsService.getConversationMessages(user, id, page, size)
    }

}