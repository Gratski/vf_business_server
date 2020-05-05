package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Language
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.locatization.LanguageDTO

interface LanguageService {

    /**
     * Gets all available languages in a given language context by its code
     */
    fun getLanguagesByLanguageCode(langCode: String): ResourcePage<LanguageDTO>

    /**
     * Gets the available languages for a given professor
     */
    fun getAvailableLanguagesForProfessor(langCode: String, professor: Professor): ResourcePage<LanguageDTO>

    /**
     * Gets the existing languages of a given professor
     */
    fun getExistingLanguagesOfProfessor(langCode: String, professor: Professor): ResourcePage<LanguageDTO>

    /**
     * Gets a language based on its id
     */
    fun getLanguageById(id: Int): Language

}