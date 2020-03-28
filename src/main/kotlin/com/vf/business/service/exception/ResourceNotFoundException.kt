package com.vf.business.service.exception

import java.lang.RuntimeException

class ResourceNotFoundException :RuntimeException {

    constructor(): super() {}
    constructor(msg: String?): super(msg) {}

}