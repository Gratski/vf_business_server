package com.vf.business.business.service.itf

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dto.classes.VFClassDTO
import com.vf.business.common.PeriodEnum
import org.springframework.data.domain.Page

interface ClassesService {

    fun getActiveClasses(pageNumber: Int, size: Int): Page<VFClassDTO>

    fun getActiveClassesByCategory(category: Category, pageNumber: Int, size: Int): Page<VFClassDTO>

}