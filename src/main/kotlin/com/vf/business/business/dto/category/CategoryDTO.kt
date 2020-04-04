package com.vf.business.business.dto.category

import com.vf.business.business.dto.AbstractDTO
import com.vf.business.business.dto.documents.PictureDTO
import java.util.Date;
import kotlin.collections.Collection;

class CategoryDTO(
        id: Int?,
        val designation: String?,
        val description: String?,
        val subCategories: Collection<CategoryDTO?>?,
        val icon: String?,
        val picture: PictureDTO?,
        createdAt: Date?,
        updatedAt: Date?
    ): AbstractDTO( id, createdAt, updatedAt );