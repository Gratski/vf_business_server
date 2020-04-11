package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.discipline.classes.DisciplineClass
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DisciplineClassesRepository : CrudRepository< DisciplineClass , Int> {

    @Query("SELECT c " +
            "FROM DisciplineClass c " +
            "WHERE c.startedAt >= :now AND (c.endedAt IS NULL OR c.endedAt < :now)")
    fun findActiveClasses(
            @Param("now") now: Date,
            page: Pageable): Page<DisciplineClass>


    @Query("SELECT c " +
            "FROM DisciplineClass c " +
            "WHERE c.discipline.category = :category AND c.startedAt >= :now AND (c.endedAt IS NULL OR c.endedAt < :now)")
    fun findActiveClassesByCategory(
            @Param("category") category: Category,
            @Param("now") now: Date,
            page: Pageable): Page<DisciplineClass>

}