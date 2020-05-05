package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.ProfessorDetails
import com.vf.business.business.dto.user.professor.ProfessorDetailsDTO

class ProfessorDetailsMapper {

    object Mapper {

        fun map(pd: ProfessorDetails): ProfessorDetailsDTO {
            return ProfessorDetailsDTO(
                    id = pd.id,
                    designation = pd.designation,
                    description = pd.description,
                    quote = pd.quote
            )
        }

    }

}