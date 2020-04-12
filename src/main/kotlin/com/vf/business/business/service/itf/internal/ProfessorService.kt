package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.user.professor.UpdateProfessorProfileDetailsDTO

interface ProfessorService {

    /**
     * Updates professor profile details
     */
    fun updateProfessorProfileDetails(professor: Professor, dto: UpdateProfessorProfileDetailsDTO)

}