package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.User

interface WalletService {

    /**
     * @throws WalletException if somethins goes wrong
     */
    fun deposit(attendants: Int, user: User)

}