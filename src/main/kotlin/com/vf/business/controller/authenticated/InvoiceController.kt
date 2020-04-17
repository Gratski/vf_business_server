package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.service.itf.internal.InvoiceService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/invoices")
class InvoiceController(
        val usersService: UsersService,
        val invoiceService: InvoiceService
) {

    @Secured
    @PostMapping("")
    fun sendInvoice(principal: Principal, @RequestParam file: MultipartFile) {
        val professor = (usersService.getUser(principal) as Professor)
        invoiceService.sendInvoice(professor, file)
    }

}