package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.LanguageContext
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.ProfessorDetails
import com.vf.business.business.dao.repo.LanguageContextRepository
import com.vf.business.business.dao.repo.LanguageRepository
import com.vf.business.business.dao.repo.ProfessorDetailsRepository
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.locatization.CreateLanguageContextDTO
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.LanguageContextService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.stereotype.Service
import java.util.Date
import javax.transaction.Transactional

@Service
class LanguageContextServiceImpl(
        val languageRepo: LanguageRepository,
        val languageContextRepo: LanguageContextRepository,
        val professorDetailsRepo: ProfessorDetailsRepository
): LanguageContextService {

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun createLanguageContext(professor: Professor, dto: CreateLanguageContextDTO): CreateOperationResponseDTO {
        val languageOpt = languageRepo.findById(dto.languageId)
        languageOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE,
                    arrayOf(Translator.toLocale(MessageCodes.LANGUAGE))))
        }
        val language = languageOpt.get()

        // check if this professor does not have this language context yet
        professor.languageContexts.forEach {
            if ( it.language.id == dto.languageId ) {
                throw ResourceConflictException(
                        Translator.toLocale(MessageCodes.LANGUAGE_CONTEXT_ALREADY_EXISTS)
                )
            }
        }

        val now = Date()
        val languageContext = LanguageContext(
            professor = professor,
            language = language,
            isNative = dto.isNative,
            disciplines = mutableListOf(),
            createdAt = now,
            updatedAt = now
        )
        languageContextRepo.save(languageContext)

        // create professor details for this language context
        val details = ProfessorDetails(
                designation = dto.professorDetails.designation,
                description = dto.professorDetails.description,
                quote = dto.professorDetails.quote,
                languageContext = languageContext,
                createdAt = now,
                updatedAt = now
        )
        professorDetailsRepo.save(details)

        languageContext.professorDetails = details
        languageContextRepo.save(languageContext)

        return CreateOperationResponseDTO(languageContext.id)
    }

}