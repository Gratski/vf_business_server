package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.Picture
import com.vf.business.business.dto.documents.PictureDTO

class PictureMapper {

    object Mapper {

        fun map(input: Picture?): PictureDTO? {
            input?.let {
                return PictureDTO(
                        id = input.id,
                        designation = input.designation,
                        extension = input.extension,
                        createdAt = input.createdAt,
                        updatedAt = input.updatedAt
                )
            }
            return null;
        }

    }

}