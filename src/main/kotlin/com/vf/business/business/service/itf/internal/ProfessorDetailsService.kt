package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.locatization.CreateProfessorDetailsDTO
import com.vf.business.business.dto.locatization.UpdateProfessorDetailsDTO

interface ProfessorDetailsService {

    fun updateProfessorDetails(id: Int, professor: Professor, details: UpdateProfessorDetailsDTO)

    fun createProfessorDetails(professor: Professor, dto: CreateProfessorDetailsDTO): CreateOperationResponseDTO

}