package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.classes.DisciplineClass
import com.vf.business.business.dao.repo.ClassesRepository
import com.vf.business.business.dto.classes.VFClassDTO
import com.vf.business.business.service.itf.ClassesService
import com.vf.business.business.utils.VFClassMapper
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service
import java.util.*

@Service
class ClassesServiceImpl(
        val classesRepo: ClassesRepository
) : ClassesService {

    override fun getActiveClasses(pageNumber: Int, size: Int): Page<VFClassDTO> {
        if (pageNumber < 0 || size <= 0)
            return Page.empty()

        val now = Date()
        val pageRequest = PageRequest.of((pageNumber * size), size)
        val classesPage = classesRepo.findActiveClasses(now, pageRequest)

        val resultList = arrayListOf<VFClassDTO>()

        classesPage?.iterator().forEach {
            resultList.add(VFClassMapper.Mapper.map(it))
        }

        return PageImpl<VFClassDTO>(resultList, pageRequest, classesPage.totalElements)
    }

    override fun getActiveClassesByCategory(category: Category, pageNumber: Int, size: Int): Page<VFClassDTO> {
        if (pageNumber < 0 || size <= 0)
            return Page.empty()

        val now = Date()
        val pageRequest = PageRequest.of((pageNumber * size), size)
        val classesPage: Page<DisciplineClass> = classesRepo.findActiveClassesByCategory(category, now, pageRequest)
        val resultList = arrayListOf<VFClassDTO>()


        return PageImpl<VFClassDTO>(resultList, pageRequest, classesPage.totalElements)
    }

}