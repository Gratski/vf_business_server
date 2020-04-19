package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "category_translation")
class CategoryTranslation(
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "category_id")
        open var category: Category,

        @ManyToOne
        @JoinColumn(name = "language_id")
        open var language: Language,

        open var designation: String,
        open var description: String,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}