package com.vf.business.business.exception

import java.lang.RuntimeException

class ResourceConflictException : RuntimeException {

    constructor(): super() {}
    constructor(msg: String?): super(msg) {}

}