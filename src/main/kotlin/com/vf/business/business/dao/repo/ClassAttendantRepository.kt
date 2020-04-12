package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.discipline.classes.ClassAttendant
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface ClassAttendantRepository: CrudRepository<ClassAttendant, Int> {
}