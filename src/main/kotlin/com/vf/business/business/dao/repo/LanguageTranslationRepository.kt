package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.LanguageTranslation
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface LanguageTranslationRepository: CrudRepository<LanguageTranslation, Int> {

    fun findByCode(code: String): List<LanguageTranslation>

    /**
     * Gets the languages in a specific language
     * for those that there is not langauge context for a given professor
     */
    @Query("SELECT LT " +
            "FROM LanguageTranslation LT, Language L " +
            "WHERE LT.code = :langCode AND LT.language = L AND L NOT IN " +
            "(" +
            "SELECT LC.language " +
            "FROM LanguageContext LC " +
            "WHERE LC.professor.id = :id " +
            ")" +
            "")
    fun findAvailableLanguagesForProfessor(@Param("langCode") langCode: String, @Param("id") id: Int?): List<LanguageTranslation>

    /**
     * Gets the languages in a specific language
     * for those there is language context for a given professor
     */
    @Query("SELECT LT " +
            "FROM LanguageTranslation LT, Language L " +
            "WHERE LT.code = :langCode AND LT.language = L AND L IN " +
            "(" +
            "SELECT LC.language " +
            "FROM LanguageContext LC " +
            "WHERE LC.professor.id = :id" +
            ")" +
            "")
    fun findExistingLanguagesOfProfessor(@Param("langCode") langCode: String, @Param("id") id: Int?): List<LanguageTranslation>

}