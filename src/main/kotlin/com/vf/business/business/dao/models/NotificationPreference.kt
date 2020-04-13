package com.vf.business.business.dao.models

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "notification_preference")
class NotificationPreference(
        id: Int? = null,

        @Column(name = "notification_type")
        @Enumerated(EnumType.STRING)
        open var notificationType: NotificationType,

        @ManyToOne
        @JoinColumn(name = "app_user_id")
        open var user: User,

        @Column(name = "enabled")
        open var enabled: Boolean? = true,

        createdAt: Date,
        updatedAt: Date
) : AbstractEntity (
        id, createdAt, updatedAt
){
}