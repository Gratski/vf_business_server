package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Professor
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfessorRepository: CrudRepository<Professor, Int> {
}