package com.vf.business.business.service.impl.internal

import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.dao.models.Language
import com.vf.business.business.dao.models.LanguageTranslation
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.repo.LanguageRepository
import com.vf.business.business.dao.repo.LanguageTranslationRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.locatization.LanguageDTO
import com.vf.business.business.service.itf.internal.LanguageService
import com.vf.business.business.utils.mapper.LanguageMapper
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.stereotype.Service

@Service
class LanguageServiceImpl(
        val langRepo: LanguageRepository,
        val langTranslationsRepo: LanguageTranslationRepository
): LanguageService {

    override fun getLanguagesByLanguageCode(langCode: String): ResourcePage<LanguageDTO> {
        val language = getLanguageByCode(langCode)
        return mapLanguageTranslationToDTO(langTranslationsRepo.findByCode(language.code))
    }

    override fun getAvailableLanguagesForProfessor(langCode: String, professor: Professor): ResourcePage<LanguageDTO> {
        val language = getLanguageByCode(langCode)
        return mapLanguageTranslationToDTO(langTranslationsRepo.findAvailableLanguagesForProfessor(language.code, professor.id))
    }

    override fun getExistingLanguagesOfProfessor(langCode: String, professor: Professor): ResourcePage<LanguageDTO> {
        val language = getLanguageByCode(langCode)
        return mapLanguageTranslationToDTO(langTranslationsRepo.findExistingLanguagesOfProfessor(language.code, professor.id))
    }

    override fun getLanguageById(id: Int): Language {
        val langOpt = langRepo.findById(id)
        langOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.COUNTRY)))
            )
        }
        return langOpt.get()
    }

    private fun getLanguageByCode(langCode: String): Language {
        val langOpt = langRepo.findFirstByCode(langCode)
        return langOpt.orElseGet(
            return langRepo.findFirstByCode("en").get()
        )
    }

    private fun mapLanguageTranslationToDTO(translations: List<LanguageTranslation>): ResourcePage<LanguageDTO> {
        val result = mutableListOf<LanguageDTO>()
        translations.forEach {
            result.add(LanguageMapper.Mapper.map(it))
        }
        return ResourcePage<LanguageDTO>(items = result, total = result.size.toLong())
    }

}