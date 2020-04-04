package com.vf.business.business.service.itf

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dto.discipline.DisciplineDTO
import org.springframework.data.domain.Pageable

interface DisciplineService {

    fun getDiscipline(id: Int): DisciplineDTO

    fun getDisciplinesByCategory(category: Category, page: Pageable): Collection<DisciplineDTO>

}