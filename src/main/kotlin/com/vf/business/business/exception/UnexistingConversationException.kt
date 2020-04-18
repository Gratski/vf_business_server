package com.vf.business.business.exception

class UnexistingConversationException: RuntimeException {

    constructor(): super() {}
    constructor(msg: String?): super(msg) {}

}