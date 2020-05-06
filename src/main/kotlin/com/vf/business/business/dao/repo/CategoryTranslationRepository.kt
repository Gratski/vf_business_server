package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.CategoryTranslation
import com.vf.business.business.dao.models.Language
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryTranslationRepository: CrudRepository<CategoryTranslation, Int> {

    fun findAllByLanguage(language: Language): Collection<CategoryTranslation>

    fun findByCategoryIdAndLanguage(categoryId: Int, language: Language): Optional<CategoryTranslation>

    @Query("SELECT CT FROM CategoryTranslation CT, Category C WHERE C.parent IS NOT null AND C.parent.id = :parentId AND CT.category = C AND CT.language = :language")
    fun findByParentIdAndLanguage(parentId: Int, language: Language): List<CategoryTranslation>

}