package com.vf.business.business.dao.models

import com.vf.business.business.dao.models.documents.Picture
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "category")
class Category(
        id: Int?,

        @ManyToOne(fetch = FetchType.LAZY, optional=true)
        @JoinColumn(name="parent")
        open var parent: Category?,
        open var designation: String?,
        open var description: String?,
        open var icon: String?,

        @OneToMany(fetch = FetchType.LAZY, cascade = [CascadeType.ALL])
        open var subCategories: Collection<Category>?,

        @ManyToOne(fetch = FetchType.EAGER, optional = true)
        open var picture: Picture?,

        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
);