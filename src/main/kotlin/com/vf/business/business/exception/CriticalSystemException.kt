package com.vf.business.business.exception

class CriticalSystemException: RuntimeException {

    constructor(): super() {}
    constructor(msg: String?): super(msg) {}

}