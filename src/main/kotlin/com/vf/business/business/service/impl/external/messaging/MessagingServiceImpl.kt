package com.vf.business.business.service.impl.external.messaging

import com.google.firebase.messaging.*
import com.vf.business.business.events.EventKeyEnum
import com.vf.business.business.events.EventLabelsEnum
import com.vf.business.business.events.EventTypeEnum
import com.vf.business.business.service.itf.external.messaging.MessagingService
import org.springframework.stereotype.Service

@Service
class MessagingServiceImpl: MessagingService {

    override fun multiCastLabeledMessage(eventType: EventTypeEnum, label: EventLabelsEnum, body: String, sendTo: ArrayList<String>) {
        val map = HashMap<String, String>()
        map[EventKeyEnum.EVENT_TYPE.toString()] = eventType.toString()
        map[EventKeyEnum.BODY.toString()] = body

        multiCastLabeledMessage(map, label.toString(), sendTo)
    }

    override fun multiCastLabeledMessage(msgMap: Map<String, String>, label: String, sendTo: ArrayList<String>) {
        if(sendTo.size == 0) { return }

        val msgBuilder = MulticastMessage.builder().addAllTokens(sendTo)
        msgBuilder.putAllData(msgMap)

        try {
            val message = msgBuilder.build()
            val response = FirebaseMessaging.getInstance().sendMulticast(message)
            //TODO: remove this print
            println(response.successCount.toString() + " messages were sent successfully")
        } catch (e: FirebaseMessagingException) {
            //TODO: pensar no que fazer aqui
        }
    }

    override fun broadCastLabeledMessage(msgMap: Map<String, String>, label: String, topic: String) {
        val msgBuilder = Message.builder()
                .setTopic(topic)
                .setFcmOptions(
                        FcmOptions.withAnalyticsLabel(label))
        msgBuilder.putAllData(msgMap)

        val message = msgBuilder.build()
        try {
            val response = FirebaseMessaging.getInstance().send(message)
            //TODO: remove this print
            println("Successfully sent message: $response")
        } catch (e: FirebaseMessagingException) {
            //TODO: pensar no que fazer aqui
        }
    }

    override fun sendLabeledMessageToSingleUser(eventType: EventTypeEnum, label: EventLabelsEnum, body: String, sendTo: String) {
        val map = HashMap<String, String>()
        map[EventKeyEnum.EVENT_TYPE.toString()] = eventType.toString()
        map[EventKeyEnum.BODY.toString()] = body

        sendLabeledMessageToSingleUser(map, label.toString(), sendTo)
    }

    override fun sendLabeledMessageToSingleUser(msgMap: Map<String, String>, label: String, sendTo: String) {
        val msgBuilder = Message.builder()
                .setToken(sendTo)
                .setFcmOptions(
                        FcmOptions.withAnalyticsLabel(label))
        msgBuilder.putAllData(msgMap)

        val message = msgBuilder.build()
        try {
            val response = FirebaseMessaging.getInstance().send(message)
            //TODO: remove this print
            println("Successfully sent message: $response")
        } catch (e: FirebaseMessagingException) {
            //TODO: pensar no que fazer aqui
        }
    }
}