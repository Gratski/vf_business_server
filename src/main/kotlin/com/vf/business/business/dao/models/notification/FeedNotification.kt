package com.vf.business.business.dao.models.notification

import com.vf.business.business.dao.models.User
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "feed_notification")
@Inheritance(strategy = InheritanceType.JOINED)
abstract class FeedNotification(
        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        open var id: Long? = null,

        @ManyToOne
        @JoinColumn(name = "target_user_id")
        open var targetUser: User,

        open var seen: Boolean,
        open var createdAt: Date,
        open var updatedAt: Date
)