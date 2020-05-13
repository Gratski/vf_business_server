package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.User
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.payments.*

interface WalletService {

    /**
     * @throws WalletException if somethins goes wrong
     */
    fun deposit(attendants: Int, user: User)

    /**
     * Gets a page of transactions of the given user
     */
    fun getTransactions(user: User, page: Int, size: Int): ResourcePage<TransactionDTO>

    /**
     * Gets the available Payment Methods for a given professor wallet
     */
    fun getPaymentMethods(professor: Professor): ResourcePage<PaymentMethodDTO>

    /**
     * Creates a new payment method for a given professor
     */
    fun createPaymentMethod(professor: Professor, dto: CreatePaymentMethodDTO): CreateOperationResponseDTO

    /**
     * Makes a given payment method the default one given its ID
     */
    fun makePaymentMethodDefault(professor: Professor, paymentMethodId: Int)

    /**
     * Removes a given payment method given its ID
     */
    fun deletePaymentMethod(professor: Professor, paymentMethodId: Int)

    /**
     * Gets all existing currencies
     */
    fun getCurrencies(): ResourcePage<CurrencyDTO>

    /**
     * Gets the user currency
     */
    fun getUserCurrency(user: User): CurrencyDTO

    /**
     * Updates user currency
     */
    fun updateUserCurrency(user: User, dto: UpdateCurrencyDTO)

}