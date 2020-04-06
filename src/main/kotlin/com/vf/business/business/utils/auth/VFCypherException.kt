package com.vf.business.business.utils.auth

class VFCypherException : RuntimeException {

    constructor()
    constructor(msg: String): super(msg)
    constructor(t: Throwable): super(t)
    constructor(msg: String, t: Throwable): super(msg, t)

}