package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.comms.invitation.InvitationInDTO

interface InvitationService {

    fun sendInvitationMessage(professor: Professor, dto: InvitationInDTO)

}