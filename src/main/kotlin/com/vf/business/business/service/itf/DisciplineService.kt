package com.vf.business.business.service.itf

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.discipline.CreateDisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.UpdateDisciplineDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.common.PeriodEnum
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable

interface DisciplineService {

    fun getDiscipline(id: Int): DisciplineDTO

    fun getDisciplinesByCategory(category: Category, page: Pageable): Collection<DisciplineDTO>

    fun getDisciplinesByCategoryAndPeriodOfDay(
            category: Category, period: PeriodEnum,
            page: Pageable): Page<DisciplineDTO>

    fun createDiscipline(professor: Professor, newDiscipline: CreateDisciplineDTO): CreateOperationResponseDTO

    fun enableDisable(id: Int, isEnabled: Boolean)

    fun updateDiscipline(id: Int, dto: UpdateDisciplineDTO, professor: Professor)

}