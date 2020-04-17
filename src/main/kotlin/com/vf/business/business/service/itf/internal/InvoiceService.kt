package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import org.springframework.web.multipart.MultipartFile

interface InvoiceService {

    fun sendInvoice(professor: Professor, file: MultipartFile)

}