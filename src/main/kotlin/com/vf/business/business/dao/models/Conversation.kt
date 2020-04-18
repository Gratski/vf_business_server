package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "conversation")
class Conversation(
        id: Int? = null,

        @OrderBy("createdAt DESC")
        @OneToMany(mappedBy = "conversation")
        open var messages: MutableList<ConversationMessage>,

        @OneToMany(mappedBy = "conversation")
        open var correspondents: MutableList<ConversationCorrespondent>,

        createdAt: Date,
        updatedAt: Date
): AbstractEntity(id, createdAt, updatedAt) {
}