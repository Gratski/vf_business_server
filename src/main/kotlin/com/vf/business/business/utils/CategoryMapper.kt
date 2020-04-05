package com.vf.business.business.utils

import com.vf.business.business.dao.models.Category
import com.vf.business.business.dto.category.CategoryDTO
import java.util.*

class CategoryMapper {

    object Mapper {

        fun map(input: Category?): CategoryDTO {
                return CategoryDTO(
                        id = input?.id,
                        designation =  input?.designation,
                        description =  input?.description,
                        subCategories = map(input?.subCategories),
                        icon = input?.icon,
                        picture =  PictureMapper.Mapper.map(input?.picture),
                        createdAt = input?.createdAt,
                        updatedAt = input?.updatedAt
                )
        }

        fun map(input: Collection<Category>?): MutableList<CategoryDTO?> {
            input
                ?.let {
                    val result = arrayListOf<CategoryDTO?>()
                    input.forEach {
                        result.add(map(it))
                    }
                    return result
                }
                ?: return Collections.emptyList<CategoryDTO>()
        }

    }

}