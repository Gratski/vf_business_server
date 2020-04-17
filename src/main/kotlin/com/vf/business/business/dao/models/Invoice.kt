package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "invoice")
class Invoice(
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "sent_by")
        open var emittedBy: Professor,

        @Column(name = "doc_url")
        open var docUrl: String,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}