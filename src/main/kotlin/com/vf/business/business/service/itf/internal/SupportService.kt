package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.comms.support.SupportContactInDTO

interface SupportService {

    /**
     * Sends a support contact to support teams on behalf of a professor
     */
    fun sendSupportMessage(professor: Professor, dto: SupportContactInDTO)

}