package com.vf.business.business.service.itf

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.common.PeriodEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface DisciplineService {

    fun getDiscipline(id: Int): DisciplineDTO

    fun getDisciplinesByCategory(category: Category, page: Pageable): Collection<DisciplineDTO>

    fun getDisciplinesByCategoryAndPeriodOfDay(
            category: Category, period: PeriodEnum,
            page: Pageable): Page<DisciplineDTO>

    fun enableDisable(id: Int, isEnabled: Boolean)

}