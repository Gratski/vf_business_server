package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.User
import com.vf.business.business.dao.models.notification.ClassFeedNotification
import com.vf.business.business.dao.models.notification.FeedNotification
import com.vf.business.business.dao.models.notification.MessageFeedNotification
import com.vf.business.business.dao.models.notification.SystemFeedNotification
import com.vf.business.business.dao.repo.FeedNotificationRepository
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.notifications.feed.*
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.FeedNotificationService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.data.domain.PageRequest
import org.springframework.stereotype.Service

@Service
class FeedNotificationServiceImpl(
        val feedNotificationRepo: FeedNotificationRepository
): FeedNotificationService {

    override fun findProfessorNotifications(professor: Professor, page: Int, size: Int): ResourcePage<ListItemFeedNotificationDTO> {
        val pageReq = PageRequest.of(page, size)
        val nPage = feedNotificationRepo.findByTargetUserIdOrderByCreatedAtDesc(professor.id!!, pageReq)
        val results = mutableListOf<ListItemFeedNotificationDTO>()

        nPage.forEach {
            results.add(convertIntoListItem(it))
        }

        return ResourcePage(
                total = nPage.totalElements,
                items = results
        )
    }

    override fun findSingleNotification(user: User, id: Long): ListItemFeedNotificationDTO {
        val nOpt = feedNotificationRepo.findById(id)
        nOpt.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.NOTIFICATION))))
        }
        return convertIntoListItem(nOpt.get())
    }

    private fun convertIntoListItem(it: FeedNotification): ListItemFeedNotificationDTO {
        val item = ListItemFeedNotificationDTO(
                id = it.id!!,
                date = it.createdAt
        )
        if ( it is ClassFeedNotification ) {
            item.type = FeedNotificationType.CLASS_NOTIFICATION
            item.classObj = ListItemFeedNotificationDisciplineClassDTO(
                    discipline = it.disciplineClass.discipline.designation!!,
                    category = it.disciplineClass.discipline.category?.designation!!,
                    language = it.disciplineClass.discipline.languageContext.language.languageName,
                    notificationType = it.notificationType
            )
        } else if ( it is MessageFeedNotification ) {
            item.type = FeedNotificationType.MESSAGE_NOTIFICATION
            item.messageObj = ListItemFeedNotificationMessageDTO(
                    conversationId = it.conversation.id!!,
                    fromId = it.user.id!!,
                    fromName = "${it.user.firstName} ${it.user.lastName}",
                    fromCountry = it.user.nationality?.countryName!!,
                    body = it.message
            )
        } else if ( it is SystemFeedNotification ) {
            item.type = FeedNotificationType.SYSTEM_NOTIFICATION
            item.systemObj = ListItemFeedNotificationSystemDTO(
                    title = it.title,
                    subTitle = it.subTitle,
                    body = it.body
            )
        }
        return item
    }

}