package com.vf.business.business.dao.models.notification

import com.vf.business.business.dao.models.User
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Table

@Entity
@Table(name = "system_feed_notification")
class SystemFeedNotification(
        id: Long? = null,

        @Column(name = "title")
        open var title: String,

        @Column(name = "sub_title")
        open var subTitle: String? = null,

        @Column(name = "body")
        open var body: String,

        targetUser: User,
        seen: Boolean,
        createdAt: Date,
        updatedAt: Date
): FeedNotification(id, targetUser, seen, createdAt, updatedAt)