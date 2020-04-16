package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.SupportContact
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface SupportContactRepository: CrudRepository<SupportContact, Int> {
}