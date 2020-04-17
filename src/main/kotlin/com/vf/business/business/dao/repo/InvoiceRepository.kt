package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Invoice
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface InvoiceRepository: CrudRepository<Invoice, Int> {
}