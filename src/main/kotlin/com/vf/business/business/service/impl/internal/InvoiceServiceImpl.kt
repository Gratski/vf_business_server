package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Invoice
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.repo.InvoiceRepository
import com.vf.business.business.service.itf.internal.CommunicationsService
import com.vf.business.business.service.itf.internal.InvoiceService
import com.vf.business.business.service.itf.internal.StorageService
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.transaction.Transactional

@Service
class InvoiceServiceImpl(
        val storageService: StorageService,
        val commsService: CommunicationsService,
        val invoiceRepo: InvoiceRepository
): InvoiceService {

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun sendInvoice(professor: Professor, file: MultipartFile) {
        //store file
        val storeInvoiceResponse = storageService.storeInvoice(file)

        // register invoice
        val now = Date();
        val invoice = Invoice(
            emittedBy = professor,
            docUrl = storeInvoiceResponse.url,
            createdAt = now,
            updatedAt = now
        )
        invoiceRepo.save(invoice)

        // publish to billing queue
        var languageTag = LocaleContextHolder.getLocale().toLanguageTag()
        if ( languageTag == null ) languageTag = "pt-PT"
        commsService.sendBillingEmails(professor.email!!, professor.firstName!!, storeInvoiceResponse.url, invoice.id!!, languageTag)
    }

}