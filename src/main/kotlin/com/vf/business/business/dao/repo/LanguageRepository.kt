package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Language
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LanguageRepository: CrudRepository<Language, Int> {

    fun findLanguageByLanguageName(languageName: String): Optional<Language>

}