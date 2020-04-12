package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.locatization.CreateLanguageContextDTO

interface LanguageContextService {

    /**
     * Creates a new Language Context
     */
    fun createLanguageContext(professor: Professor, dto: CreateLanguageContextDTO): CreateOperationResponseDTO

}