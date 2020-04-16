package com.vf.business.business.service.impl.internal

import com.google.gson.Gson
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.comms.invitation.InvitationMessage
import com.vf.business.business.dto.comms.support.SupportMessage
import com.vf.business.business.service.itf.internal.CommunicationsService
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service

@Service
class CommunicationsServiceImpl(
    val rabbitTemplate: RabbitTemplate
): CommunicationsService {

    override fun sendEmailTo(to: String, content: String) {

    }

    override fun sendSupportEmail(ticketID: String, professor: Professor, languageTag: String) {
        val supportMessage = SupportMessage(
                id = professor.id!!,
                to = professor.email!!,
                languageTag = languageTag,
                username = professor.firstName!!,
                ticketId = ticketID
        )

        val props = MessageProperties()
        props.contentType = "json"
        val msg = Message(Gson().toJson(supportMessage).toByteArray(), props)
        rabbitTemplate.encoding = "application/json"
        rabbitTemplate.convertAndSend("comms.email.support.professors", msg)
    }

    override fun sendInvitationEmail(to: Array<String>, professor: Professor, languageTag: String) {
        val invitationMessage = InvitationMessage(
            to = to,
            languageTag = languageTag,
            fromUsername = professor.firstName!!
        )

        val props = MessageProperties()
        props.contentType = "json"
        val msg = Message(Gson().toJson(invitationMessage).toByteArray(), props)
        rabbitTemplate.encoding = "application/json"
        rabbitTemplate.convertAndSend("comms.email.invitation.professors", msg)
    }

}