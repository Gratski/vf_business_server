package com.vf.business.business.exception

class ExternalOperationException : RuntimeException {

    constructor(): super() {}
    constructor(msg: String?): super(msg) {}

}