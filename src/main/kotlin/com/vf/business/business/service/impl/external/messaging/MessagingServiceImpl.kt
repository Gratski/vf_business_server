package com.vf.business.business.service.impl.external.messaging

import com.google.firebase.messaging.*
import com.vf.business.business.service.itf.external.messaging.MessagingService
import org.springframework.stereotype.Service

@Service
class MessagingServiceImpl: MessagingService {

    override fun multiCastLabeledMessage(msgMap: Map<String, String>, label: String, sendTo: ArrayList<String>) {
        if(sendTo.size == 0) { return }

        val msgBuilder = MulticastMessage.builder().addAllTokens(sendTo)
        msgMap.keys?.forEach {
            msgBuilder.putData(it, msgMap[it])
        }

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
        msgMap.keys?.forEach {
            msgBuilder.putData(it, msgMap[it])
        }

        val message = msgBuilder.build()
        try {
            val response = FirebaseMessaging.getInstance().send(message)
            //TODO: remove this print
            println("Successfully sent message: $response")
        } catch (e: FirebaseMessagingException) {
            //TODO: pensar no que fazer aqui
        }
    }

    override fun sendLabeledMessageToSingleUser(msgMap: Map<String, String>, label: String, sendTo: String) {
        val msgBuilder = Message.builder()
                .setToken(sendTo)
                .setFcmOptions(
                        FcmOptions.withAnalyticsLabel(label))
        msgMap.keys?.forEach {
            msgBuilder.putData(it, msgMap[it])
        }

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