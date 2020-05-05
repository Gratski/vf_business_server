package com.vf.business.business.service.impl.internal

import com.google.gson.Gson
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.comms.auth.PasswordRecoveryMessage
import com.vf.business.business.dto.comms.invitation.InvitationMessage
import com.vf.business.business.dto.comms.invoice.InvoiceMessage
import com.vf.business.business.dto.comms.support.SupportMessage
import com.vf.business.business.dto.comms.welcome.ProfessorWelcomeMessage
import com.vf.business.business.service.itf.internal.CommunicationsService
import org.springframework.amqp.core.Message
import org.springframework.amqp.core.MessageProperties
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.stereotype.Service
import java.util.*

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

    override fun sendPasswordRecoveryEmail(email: String, username: String, token: String, languageTag: String) {
        val pwdRecoveryMessage = PasswordRecoveryMessage(
                to = email,
                languageTag = languageTag,
                username = username,
                token = token
        )

        //TODO: Generate dynamic link here

        val props = MessageProperties()
        props.contentType = "json"
        val msg = Message(Gson().toJson(pwdRecoveryMessage).toByteArray(), props)
        rabbitTemplate.encoding = "application/json"
        rabbitTemplate.convertAndSend("comms.email.auth.passrecovery", msg)
    }

    override fun sendWelcomeEmailToProfessor(name: String, email: String, accessCode: String, language: String) {
        val welcomeMessage = ProfessorWelcomeMessage(
                username = name,
                to = email,
                languageTag = Locale(language, "").toLanguageTag(),
                accessCode = accessCode,
                link = "Dynamiclink"
        )

        // TODO: generate dynamic link here

        val props = MessageProperties()
        props.contentType = "json"
        val msg = Message(Gson().toJson(welcomeMessage).toByteArray(), props)
        rabbitTemplate.encoding = "application/json"
        rabbitTemplate.convertAndSend("comms.email.welcome.professors", msg)
    }

    override fun sendBillingEmails(email: String, firstName: String, url: String, id: Int, languageTag: String) {
        val invoiceMessage = InvoiceMessage(
                to = email,
                username = firstName,
                docUrl = url,
                invoiceId = String.format("%d", id),
                languageTag = languageTag
        )

        val props = MessageProperties()
        props.contentType = "json"
        val msg = Message(Gson().toJson(invoiceMessage).toByteArray(), props)
        rabbitTemplate.encoding = "application/json"
        rabbitTemplate.convertAndSend("comms.email.invoice", msg)
    }

}