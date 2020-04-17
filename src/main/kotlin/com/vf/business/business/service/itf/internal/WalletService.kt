package com.vf.business.business.service.itf.internal

interface WalletService {

    /**
     * @throws WalletException if somethins goes wrong
     */
    fun deposit(amount: Double, wallet: Wallet)

}