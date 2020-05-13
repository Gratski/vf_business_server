package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.CategoryTranslation
import com.vf.business.business.dao.models.Language
import com.vf.business.business.dao.models.Professor
import org.springframework.cache.annotation.Cacheable
import org.springframework.data.domain.Sort
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CategoryTranslationRepository: CrudRepository<CategoryTranslation, Int> {

    @Cacheable("categories")
    @Query("SELECT CT FROM CategoryTranslation CT, Language L WHERE L = :language AND L = CT.language AND CT.category.parent IS NULL")
    fun findAllTopCategoriesByLanguage(@Param("language") language: Language, sort: Sort): Collection<CategoryTranslation>

    fun findByCategoryIdAndLanguage(categoryId: Int, language: Language): Optional<CategoryTranslation>

    @Cacheable("subCategories")
    @Query("SELECT CT FROM CategoryTranslation CT, Category C WHERE C.parent IS NOT null AND C.parent.id = :parentId AND CT.category = C AND CT.language = :language")
    fun findByParentIdAndLanguage(@Param("parentId") parentId: Int, @Param("language") language: Language, sort: Sort): List<CategoryTranslation>

    /**
     * Gets all the category translations for those a professor has already disciplines created for
     */
    @Query("SELECT DISTINCT CT FROM CategoryTranslation CT, Category C, Discipline D, LanguageContext LC WHERE CT.language.id = :languageId AND CT.category = C AND C = D.category AND D.status = 2 AND D.languageContext = LC AND LC.professor = :professor")
    fun findByProfessorAndLanguageId(@Param("professor") professor: Professor, @Param("languageId") languageId: Int): List<CategoryTranslation>

}