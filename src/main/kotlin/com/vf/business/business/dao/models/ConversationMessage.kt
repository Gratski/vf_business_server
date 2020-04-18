package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "conversation_message")
class ConversationMessage(
        id: Int? = null,

        @ManyToOne
        @JoinColumn(name = "conversation_id")
        open var conversation: Conversation,

        @ManyToOne
        @JoinColumn(name = "sender_id")
        open var sender: User,

        @Column(name = "body")
        open var body: String,

        @Column(name = "seen")
        open var seen: Boolean,

        @Column(name = "seen_at")
        open var seen_at: Date,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}