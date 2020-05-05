package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.NotificationPreference
import com.vf.business.business.dao.models.NotificationType
import com.vf.business.business.dao.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface NotificationPreferenceRepository: CrudRepository<NotificationPreference, Int> {

    fun findByUser(user: User): List<NotificationPreference>

    fun findByNotificationTypeAndUser(type: NotificationType, user: User): Optional<NotificationPreference>

}