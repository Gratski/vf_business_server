package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Language
import com.vf.business.business.dao.models.LanguageContext
import com.vf.business.business.dao.models.Professor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface LanguageContextRepository: CrudRepository<LanguageContext, Int> {

    /**
     * Gets a language context based on language and professor
     */
    fun findByLanguageIdAndProfessor(languageId: Int, professor: Professor): Optional<LanguageContext>

}