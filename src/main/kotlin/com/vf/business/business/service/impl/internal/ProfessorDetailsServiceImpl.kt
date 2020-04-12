package com.vf.business.business.service.impl.internal

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.ProfessorDetails
import com.vf.business.business.dao.repo.ProfessorDetailsRepository
import com.vf.business.business.dto.locatization.UpdateProfessorDetailsDTO
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.internal.ProfessorDetailsService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfessorDetailsServiceImpl(
        val professorDetailsRepo: ProfessorDetailsRepository
): ProfessorDetailsService {

    override fun updateProfessorDetails(id: Int, professor: Professor, dto: UpdateProfessorDetailsDTO) {
        val details = checkBelongsToAndGetProfessorDetails(id, professor)

        details.designation = dto.designation
        details.description = dto.description
        details.quote = dto.quote
        details.updatedAt = Date()
        professorDetailsRepo.save(details)
    }

    /**
     * Validates
     */
    private fun checkBelongsToAndGetProfessorDetails(id: Int, professor: Professor): ProfessorDetails {
        // get professor details
        val detailsOpt = professorDetailsRepo.findById(id)
        detailsOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.PROFESSOR_DETAILS)))
            )
        }
        val details = detailsOpt.get()

        // check if this professor owns this details
        var isValid = false
        for( lc in professor.languageContexts) {
            if ( details.languageContext.id == lc.id ) {
                isValid = true
                break
            }
        }
        if ( !isValid ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }

        return detailsOpt.get()
    }

}