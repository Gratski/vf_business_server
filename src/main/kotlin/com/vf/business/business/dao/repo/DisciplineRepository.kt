package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.discipline.Discipline
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface DisciplineRepository : CrudRepository<Discipline, Int> {

    /**
     * Gets a page of disciplines of a given category
     */
    fun findByCategory(category: Category, pageable: Pageable): Page<Discipline>

    /**
     * Gets a page of disciplines that contain a discipline repetition
     * that start and end time are contained by FROM and UNTIL params
     */
    @Query( "SELECT d " +
            "FROM Discipline d " +
            "WHERE " +
                "d.category = :category " +
                "AND d.enabled = true " +
                "AND d.active = true " +
                "AND d.id IN ( " +
                    "SELECT dr.discipline.id " +
                    "FROM DisciplineRepetition dr " +
                    "WHERE " +
                        "dr.discipline = d " +
                        "AND dr.startsAt >= :from " +
                        "AND dr.endsAt < :until " +
                ")"
    )
    fun findByCategoryAndPeriodOfTime(
            @Param("category") category: Category,
            @Param("from") from: Date,
            @Param("until") until: Date,
            pageable: Pageable): Page<Discipline>

}