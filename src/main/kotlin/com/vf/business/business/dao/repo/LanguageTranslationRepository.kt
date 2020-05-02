package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.LanguageTranslation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LanguageTranslationRepository: CrudRepository<LanguageTranslation, Int> {

    fun findByCode(code: String): List<LanguageTranslation>;

}