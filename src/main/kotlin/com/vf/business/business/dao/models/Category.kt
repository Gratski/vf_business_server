package com.vf.business.business.dao.models

import com.vf.business.business.dao.models.documents.Picture
import java.util.Date
import javax.persistence.*

@Entity
@Table(name = "category")
class Category(
        id: Int?,

        @ManyToOne
        @JoinColumn(name = "parent_id", referencedColumnName="id",nullable=false)
        open var parent: Category? = null,
        open var designation: String? = null,
        open var description: String? = null,
        open var icon: String? = null,

        @OneToMany(fetch = FetchType.EAGER, cascade = [CascadeType.ALL, CascadeType.PERSIST], mappedBy = "parent")
        open var subCategories: MutableList<Category>? = null,

        @OneToOne(fetch = FetchType.EAGER, optional = true)
        open var picture: Picture? = null,

        createdAt: Date?,
        updatedAt: Date?
) : AbstractEntity(
        id = id,
        createdAt = createdAt,
        updatedAt = updatedAt
);