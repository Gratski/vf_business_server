package com.vf.business.business.service.itf.internal

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.locatization.LanguageDTO

interface LanguageService {

    /**
     * Gets all available languages in a given language context by its code
     */
    fun getLanguagesByLanguageCode(langCode: String): ResourcePage<LanguageDTO>

}