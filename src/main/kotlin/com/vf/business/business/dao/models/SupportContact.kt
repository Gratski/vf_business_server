package com.vf.business.business.dao.models

import com.vf.business.business.dto.support.SupportType
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "support_contact")
class SupportContact(
        @Id
        open var id: String,
        @ManyToOne
        @JoinColumn(name = "sent_by")
        open var sentBy: User,
        open var message: String,
        @Enumerated(EnumType.STRING)
        open var subject: SupportType,
        open var viewed: Boolean? = false,
        open var solved: Boolean? = false,
        open var comment: String? = null,
        open var createdAt: Date,
        open var updatedAt: Date
) {
}