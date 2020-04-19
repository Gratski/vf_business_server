package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dao.models.CategoryTranslation
import com.vf.business.business.dto.category.CategoryDTO
import java.util.*

class CategoryMapper {

    object Mapper {

        /**
         * Maps a category translation object into a Unified Category DTO
         */
        fun map(input: CategoryTranslation?): CategoryDTO {
                return CategoryDTO(
                        id = input?.category?.id,
                        designation =  input?.designation,
                        description =  input?.description,
                        icon = input?.category?.icon,
                        picture = PictureMapper.Mapper.map(input?.category?.picture),
                        createdAt = input?.createdAt,
                        updatedAt = input?.updatedAt
                )
        }

    }

}