package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dao.models.discipline.Discipline
import com.vf.business.business.dto.discipline.classes.CreateDisciplineClassesDTO
import com.vf.business.business.dto.discipline.classes.VFClassDTO
import com.vf.business.common.RepetitionTypeEnum
import com.vf.business.common.WeekDayEnum
import org.springframework.data.domain.Page
import java.util.*

interface ClassesService {

    fun getActiveClasses(pageNumber: Int, size: Int): Page<VFClassDTO>

    fun getActiveClassesByCategory(category: Category, pageNumber: Int, size: Int): Page<VFClassDTO>

    fun createClassesFromUntil(dto: CreateDisciplineClassesDTO, discipline: Discipline)

    fun startClass(professor: Professor, classId: Int)

    fun endClass(professor: Professor, classId: Int)

    fun muteAll(professor: Professor, classId: Int)

    fun unmuteAll(professor: Professor, classId: Int)

    fun joinClass(student: Student, classId: Int)

    fun leaveClass(student: Student, classId: Int)

}