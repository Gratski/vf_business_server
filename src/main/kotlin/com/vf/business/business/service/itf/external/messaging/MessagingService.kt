package com.vf.business.business.service.itf.external.messaging

import com.vf.business.business.events.EventLabelsEnum
import com.vf.business.business.events.EventTypeEnum

interface MessagingService {

    fun multiCastLabeledMessage(eventType: EventTypeEnum, label: EventLabelsEnum, body: String, sendTo: MutableList<String>)
    fun multiCastLabeledMessage(msgMap: Map<String, String>, label: String, sendTo: MutableList<String>)

    fun broadCastLabeledMessage(msgMap: Map<String, String>, label: String, topic: String)

    fun sendLabeledMessageToSingleUser(eventType: EventTypeEnum, label: EventLabelsEnum, body: String, sendTo: String)
    fun sendLabeledMessageToSingleUser(msgMap: Map<String, String>, label: String, sendTo: String)

}