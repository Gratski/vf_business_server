package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.CategoryTranslation
import com.vf.business.business.dao.models.Language
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryTranslationRepository: CrudRepository<CategoryTranslation, Int> {

    @Query("SELECT CT FROM CategoryTranslation CT, Language L WHERE L = :language AND L = CT.language AND CT.category.parent IS NULL")
    fun findAllTopCategoriesByLanguage(@Param("language") language: Language): Collection<CategoryTranslation>

    fun findByCategoryIdAndLanguage(categoryId: Int, language: Language): Optional<CategoryTranslation>

    @Query("SELECT CT FROM CategoryTranslation CT, Category C WHERE C.parent IS NOT null AND C.parent.id = :parentId AND CT.category = C AND CT.language = :language")
    fun findByParentIdAndLanguage(@Param("parentId") parentId: Int, @Param("language") language: Language): List<CategoryTranslation>

}