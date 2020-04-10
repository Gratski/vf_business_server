package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.discipline.DisciplineSlot
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface DisciplineSlotRepository : CrudRepository<DisciplineSlot, Int> {
}