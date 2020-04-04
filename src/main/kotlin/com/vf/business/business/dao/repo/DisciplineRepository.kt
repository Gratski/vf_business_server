package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.discipline.Discipline
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DisciplineRepository : CrudRepository<Discipline, Int> {

    /**
     * Gets a page of disciplines of a given category
     */
    fun findByCategory(category: Category, pageable: Pageable): Page<Discipline>

}