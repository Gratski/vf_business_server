package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.wallet.PaymentMethod
import com.vf.business.business.dao.models.wallet.Wallet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface PaymentMethodRepository: CrudRepository<PaymentMethod, Int> {

    /**
     * Gets a payment method for a given wallet given the provided email and wallet
     */
    fun findByWalletAndPaymentEmail(wallet: Wallet, paymentEmail: String): Optional<PaymentMethod>

}