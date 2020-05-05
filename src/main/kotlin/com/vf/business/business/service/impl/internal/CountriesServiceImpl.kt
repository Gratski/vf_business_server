package com.vf.business.business.service.impl.internal

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException
import com.vf.business.business.dao.models.Country
import com.vf.business.business.dao.repo.CountryRepository
import com.vf.business.business.dao.repo.CountryTranslationsRepository
import com.vf.business.business.dao.repo.LanguageRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.locatization.CountryDTO
import com.vf.business.business.service.itf.internal.CountriesService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service

@Service
class CountriesServiceImpl(
        val countryTranslationRepo: CountryTranslationsRepository,
        val countryRepo: CountryRepository,
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

    override fun getCountry(id: Int): Country {
        val countryOpt = countryRepo.findById(id)
        countryOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.COUNTRY)))
            )
        }
        return countryOpt.get()
    }


}