package com.vf.business.business.exception

import java.lang.RuntimeException

class MissingArgumentsException: RuntimeException {

    constructor(): super() {}
    constructor(msg: String?): super(msg) {}

}