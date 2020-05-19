package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.SupportContact
import com.vf.business.business.dao.repo.SupportContactRepository
import com.vf.business.business.dto.comms.support.SupportContactInDTO
import com.vf.business.business.service.itf.internal.CommunicationsService
import com.vf.business.business.service.itf.internal.SupportService
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Service
import java.util.*

@Service
class SupportServiceImpl(
        val commsService: CommunicationsService,
        val supportCoontactRepo: SupportContactRepository
): SupportService {

    override fun sendSupportMessage(professor: Professor, dto: SupportContactInDTO) {
        // create support ticket
        val now = Date()
        val ticketID = UUID.randomUUID().toString()
        val supportContact = SupportContact(
            id = ticketID,
            sentBy = professor,
            message = dto.msg,
            subject = dto.type,
            createdAt = now,
            updatedAt = now
        )
        supportCoontactRepo.save(supportContact)

        // send email to professor confirming this support entry
        commsService.sendSupportEmail(ticketID, professor, getCurrentLanguageTag(), dto.msg)
    }

    private fun getCurrentLanguageTag(): String =
        LocaleContextHolder.getLocale().toLanguageTag()

}