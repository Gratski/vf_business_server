package com.vf.business.business.dto.notifications

import java.util.*

data class ClassCancelledNotificationDTO (
        val id: Int? = null,
        val title: String? = null,
        val professorName: String,
        val pictureUrl: String? = null,
        val cancellationMsg: String? = null,
        val date: Date
)