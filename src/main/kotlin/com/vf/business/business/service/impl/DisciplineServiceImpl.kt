package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.repo.DisciplineRepository
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.DisciplineService
import com.vf.business.business.utils.DisciplineMapper
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class DisciplineServiceImpl(
        val disciplineRepo: DisciplineRepository
) : DisciplineService {

    override fun getDiscipline(id: Int): DisciplineDTO {
        val disciplineOpt = disciplineRepo.findById(id)
        disciplineOpt.orElseThrow {
            throw ResourceNotFoundException()
        }
        return DisciplineMapper.Mapper.map(disciplineOpt.get())
    }

    override fun getDisciplinesByCategory(category: Category, page: Pageable): Collection<DisciplineDTO> {
        val page = disciplineRepo.findByCategory(category, page)
        val result = arrayListOf<DisciplineDTO>()
        page.forEach {
            result.add(DisciplineMapper.Mapper.map(it))
        }
        return result
    }

    override fun enableDisable(id: Int, isEnabled: Boolean) {
        //TODO: implement validation to check if the current user can change this
        val dOpt = disciplineRepo.findById(id)
        dOpt.orElseThrow {
            throw ResourceNotFoundException()
        }
        val discipline = dOpt.get()
        discipline.enabled = isEnabled
        disciplineRepo.save(discipline)
    }

}