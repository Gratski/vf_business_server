package com.vf.business.business.dao.models.professor

import com.vf.business.business.dao.models.AbstractEntity
import com.vf.business.business.dao.models.localization.LanguageContext
import java.util.*
import javax.persistence.Entity
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "professor_context_details")
class ProfessorDetails(
        id: Int? = null,

        open var designation: String,
        open var description: String? = null,
        open var quote: String? = null,
        open var picture_url: String? = null,

        @OneToOne
        open var languageContext: LanguageContext,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}