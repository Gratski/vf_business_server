package com.vf.business.business.service.itf.external.messaging

interface MessagingService {

    fun multiCastLabeledMessage(msgMap: Map<String, String>, label: String, sendTo: ArrayList<String>)

    fun broadCastLabeledMessage(msgMap: Map<String, String>, label: String, topic: String)

    fun sendLabeledMessageToSingleUser(msgMap: Map<String, String>, label: String, sendTo: String)

}