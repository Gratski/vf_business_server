package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.ProfessorDetails
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ProfessorDetailsRepository: CrudRepository<ProfessorDetails, Int> {
}