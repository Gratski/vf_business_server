package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dao.models.Discipline
import com.vf.business.business.dto.discipline.classes.ClassCancellationDTO
import com.vf.business.business.dto.discipline.classes.CreateDisciplineClassesDTO
import com.vf.business.business.dto.discipline.classes.VFClassDTO
import org.springframework.data.domain.Page

interface ClassesService {

    fun getActiveClasses(pageNumber: Int, size: Int): Page<VFClassDTO>

    fun getActiveClassesByCategory(category: Category, pageNumber: Int, size: Int): Page<VFClassDTO>

    fun createClassesFromUntil(dto: CreateDisciplineClassesDTO, discipline: Discipline)

    fun startClass(professor: Professor, classId: Int)

    fun cancelClass(professor: Professor, classId: Int,  dto: ClassCancellationDTO)

    fun endClass(professor: Professor, classId: Int)

    fun muteAll(professor: Professor, classId: Int)

    fun unmuteAll(professor: Professor, classId: Int)

    /**
     * When a student wants to join a class
     * For Students Only
     */
    fun joinClass(student: Student, classId: Int)

    /**
     * When a student wants to leave a class
     * For Students Only
     */
    fun leaveClass(student: Student, classId: Int)

}