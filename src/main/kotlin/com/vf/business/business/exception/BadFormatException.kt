package com.vf.business.business.exception

class BadFormatException : RuntimeException {

    constructor(): super() {}
    constructor(msg: String?): super(msg) {}

}