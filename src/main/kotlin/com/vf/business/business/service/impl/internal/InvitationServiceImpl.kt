package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.comms.invitation.InvitationInDTO
import com.vf.business.business.service.itf.internal.CommunicationsService
import com.vf.business.business.service.itf.internal.InvitationService
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Service

@Service
class InvitationServiceImpl(
        val commsService: CommunicationsService
): InvitationService {

    override fun sendInvitationMessage(professor: Professor, dto: InvitationInDTO) {
        commsService.sendInvitationEmail(dto.to, professor, LocaleContextHolder.getLocale().toLanguageTag())
    }

}