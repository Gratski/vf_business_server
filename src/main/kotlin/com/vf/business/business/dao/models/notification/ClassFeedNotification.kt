package com.vf.business.business.dao.models.notification

import com.vf.business.business.dao.models.DisciplineClass
import com.vf.business.business.dao.models.User
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "class_feed_notification")
class ClassFeedNotification(
        id: Long? = null,

        @Column(name = "notification_type")
        open var notificationType: ClassFeedNotificationType,

        @ManyToOne
        @JoinColumn(name = "class_id")
        open var disciplineClass: DisciplineClass,

        @ManyToOne
        @JoinColumn(name= "app_user_id")
        open var user: User,

        @Column(name = "message")
        open var message: String? = null,

        targetUser: User,
        seen: Boolean,
        createdAt: Date,
        updatedAt: Date
): FeedNotification(id, targetUser, seen, createdAt, updatedAt)