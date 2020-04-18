package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.Entity
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "conversation_correspondent")
class ConversationCorrespondent(
        id: Long? = null,

        @ManyToOne
        @JoinColumn(name = "conversation_id")
        open var conversation: Conversation,

        @ManyToOne
        @JoinColumn(name = "app_user_id")
        open var user: User,

        createdAt: Date,
        updatedAt: Date
): AbstractLongEntity(id, createdAt, updatedAt) {
}