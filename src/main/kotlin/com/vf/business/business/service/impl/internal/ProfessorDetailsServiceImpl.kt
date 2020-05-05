package com.vf.business.business.service.impl.internal

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException
import com.vf.business.business.dao.models.LanguageContext
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.ProfessorDetails
import com.vf.business.business.dao.repo.LanguageContextRepository
import com.vf.business.business.dao.repo.LanguageRepository
import com.vf.business.business.dao.repo.ProfessorDetailsRepository
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.locatization.CreateProfessorDetailsDTO
import com.vf.business.business.dto.locatization.UpdateProfessorDetailsDTO
import com.vf.business.business.exception.MissingArgumentsException
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.internal.LanguageService
import com.vf.business.business.service.itf.internal.ProfessorDetailsService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class ProfessorDetailsServiceImpl(
        val professorDetailsRepo: ProfessorDetailsRepository,
        val languageContextRepo: LanguageContextRepository,
        val languageService: LanguageService
): ProfessorDetailsService {

    override fun updateProfessorDetails(id: Int, professor: Professor, dto: UpdateProfessorDetailsDTO) {
        val details = checkBelongsToAndGetProfessorDetails(id, professor)

        details.designation = dto.designation
        details.description = dto.description
        details.quote = dto.quote
        details.updatedAt = Date()
        professorDetailsRepo.save(details)
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun createProfessorDetails(professor: Professor, dto: CreateProfessorDetailsDTO): CreateOperationResponseDTO {
        checkRequiredFields(dto)

        val language = languageService.getLanguageById(dto.languageId!!)

        // validate if this professor already has the given language context
        professor.languageContexts.forEach {
            if ( it.language.id == language.id ) {
                throw ResourceConflictException(
                        Translator.toLocale(MessageCodes.ALREADY_EXISTING_RESOURCE)
                )
            }
        }

        // create language context
        val now = Date()
        val languageContext = LanguageContext(
                professor = professor,
                language = language,
                isNative = false,
                createdAt = now,
                updatedAt = now,
                disciplines = mutableListOf(),
                professorDetails = null
        )
        languageContextRepo.save(languageContext)

        // create language profile
        val profileDetails = ProfessorDetails(
            languageContext = languageContext,
            designation = dto.designation,
            description = dto.description,
            quote = dto.quote,
            createdAt = now,
            updatedAt = now
        )
        professorDetailsRepo.save(profileDetails)
        return CreateOperationResponseDTO(id = profileDetails.id!!)
    }

    private fun checkRequiredFields(dto: CreateProfessorDetailsDTO) {
        if ( dto.languageId == null ) {
            throw MissingArgumentsException(
                    Translator.toLocale(MessageCodes.MISSING_ARGUMENTS)
            )
        }
    }

    /**
     * Validates if a language context belongs to a given professor
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