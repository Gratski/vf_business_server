package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.repo.CountryTranslationsRepository
import com.vf.business.business.dao.repo.LanguageRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.locatization.CountryDTO
import com.vf.business.business.service.itf.internal.CountriesService
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class CountriesServiceImpl(
        val countryTranslationRepo: CountryTranslationsRepository,
        val languageRepo: LanguageRepository
): CountriesService {

    @Cacheable("countries")
    override fun getCountries(langCode: String): ResourcePage<CountryDTO> {
        val languageOpt = languageRepo.findFirstByCode(langCode)
        var code: String = "en"
        if ( languageOpt.isPresent ) {
            code = langCode
        }
        val result = mutableListOf<CountryDTO>()
        val translations = countryTranslationRepo.findByLanguageCodeOrderByDesignationAsc(code)
        translations.forEach {
            val cur = CountryDTO(id= it.country.id, countryCode = it.country.countryCode, countryName = it.designation)
            result.add(cur)
        }

        return ResourcePage<CountryDTO>(items = result, total = result.size.toLong())
    }


}