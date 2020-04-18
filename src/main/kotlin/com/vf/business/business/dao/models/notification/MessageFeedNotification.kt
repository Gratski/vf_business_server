package com.vf.business.business.dao.models.notification

import com.vf.business.business.dao.models.Conversation
import com.vf.business.business.dao.models.User
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "message_feed_notification")
class MessageFeedNotification(
        id: Long? = null,

        @ManyToOne
        @JoinColumn(name= "app_user_id")
        open var user: User,

        @ManyToOne
        @JoinColumn(name = "conversation_id")
        open var conversation: Conversation,

        @Column(name = "message")
        open var message: String,

        targetUser: User,
        seen: Boolean,
        createdAt: Date,
        updatedAt: Date
): FeedNotification(id, targetUser, seen, createdAt, updatedAt)