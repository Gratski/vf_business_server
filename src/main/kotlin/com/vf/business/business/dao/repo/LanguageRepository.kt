package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Language
import com.vf.business.business.dao.models.LanguageTranslation
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LanguageRepository: CrudRepository<Language, Int> {

    fun findFirstByCode(code: String): Optional<Language>

    fun findFirstBySystemLanguage(isSystemLanguage: Boolean): Optional<Language>

}