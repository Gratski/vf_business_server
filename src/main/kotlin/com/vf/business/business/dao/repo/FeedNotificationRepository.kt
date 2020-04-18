package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.notification.FeedNotification
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface FeedNotificationRepository: CrudRepository<FeedNotification, Long> {

    fun findByTargetUserIdOrderByCreatedAtDesc(targetUserId: Int, pageable: Pageable): Page<FeedNotification>

}