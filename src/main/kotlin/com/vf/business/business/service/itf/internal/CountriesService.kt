package com.vf.business.business.service.itf.internal

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.locatization.CountryDTO

interface CountriesService {

    /**
     * Gets all the countries in a given language
     * Uses English as default if the given language is not supported
     */
    fun getCountries(langCode: String): ResourcePage<CountryDTO>

}