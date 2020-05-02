package com.vf.business.business.service.impl.internal

import com.amazonaws.services.dynamodbv2.model.ResourceNotFoundException
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

        val langOpt = langRepo.findFirstByCode(langCode)
        var code = "en"
        if ( langOpt.isPresent ) code = langCode

        val translations = langTranslationsRepo.findByCode(code)
        val result = mutableListOf<LanguageDTO>()
        translations.forEach {
            result.add(LanguageMapper.Mapper.map(it))
        }
        return ResourcePage<LanguageDTO>(items = result, total = result.size.toLong())
    }

}