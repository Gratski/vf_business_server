package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor

interface CommunicationsService {

    fun sendEmailTo(to: String, content: String)

    fun sendSupportEmail(ticketID: String, professor: Professor, currentLanguageTag: String)

    fun sendInvitationEmail(to: Array<String>, professor: Professor, languageTag: String)

    fun sendPasswordRecoveryEmail(email: String, firstName: String, token: String, languageTag: String)

}