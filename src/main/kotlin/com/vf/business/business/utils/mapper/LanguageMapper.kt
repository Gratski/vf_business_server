package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.Language
import com.vf.business.business.dao.models.LanguageTranslation
import com.vf.business.business.dao.models.UserLanguage
import com.vf.business.business.dto.locatization.LanguageDTO

class LanguageMapper {

    object Mapper {

        /**
         * Maps a Language Translation into a Unified LanguageDTO
         */
        fun map(lt: LanguageTranslation): LanguageDTO =
                LanguageDTO(
                        id = lt.language.id,
                        designation = lt.designation
                )

        fun map(lts: MutableList<LanguageTranslation>): MutableList<LanguageDTO> {
            val result = mutableListOf<LanguageDTO>()
            lts.forEach { userLang ->
                result.add(map(userLang))
            }

            return result
        }

    }

}