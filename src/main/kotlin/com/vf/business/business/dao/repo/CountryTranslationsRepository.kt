package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.CountryTranslation
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryTranslationsRepository: CrudRepository<CountryTranslation, Int> {

    fun findByLanguageCodeOrderByDesignationAsc(languageCode: String): List<CountryTranslation>

}