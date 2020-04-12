package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.Language
import com.vf.business.business.dao.models.UserLanguage
import com.vf.business.business.dto.locatization.LanguageDTO

class LanguageMapper {

    object Mapper {

        fun map(language: Language): LanguageDTO =
                LanguageDTO(
                        id = language.id,
                        languageName = language.languageName
                )

        fun map(userLanguages: MutableList<UserLanguage>): MutableList<LanguageDTO> {
            val result = mutableListOf<LanguageDTO>()
            userLanguages.forEach { userLang ->
                result.add(map(userLang.language))
            }

            return result
        }

    }

}