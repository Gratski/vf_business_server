package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.User
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.payments.TransactionDTO

interface WalletService {

    /**
     * @throws WalletException if somethins goes wrong
     */
    fun deposit(attendants: Int, user: User)

    /**
     * Gets a page of transactions of the given user
     */
    fun getTransactions(user: User, page: Int, size: Int): ResourcePage<TransactionDTO>

}