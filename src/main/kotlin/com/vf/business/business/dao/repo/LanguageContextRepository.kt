package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.LanguageContext
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LanguageContextRepository: CrudRepository<LanguageContext, Int> {
}