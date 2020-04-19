package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.CategoryTranslation
import com.vf.business.business.dao.models.Language
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryTranslationRepository: CrudRepository<CategoryTranslation, Int> {

    fun findAllByLanguage(language: Language): Collection<CategoryTranslation>

    fun findByCategoryIdAndLanguage(categoryId: Int, language: Language): Optional<CategoryTranslation>

}