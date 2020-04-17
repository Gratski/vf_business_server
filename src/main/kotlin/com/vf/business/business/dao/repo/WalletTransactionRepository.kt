package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Wallet
import com.vf.business.business.dao.models.WalletTransaction
import org.springframework.data.repository.CrudRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Repository

@Repository
interface WalletTransactionRepository: CrudRepository<WalletTransaction, Int> {

    fun findByWallet(wallet: Wallet, pageable: Pageable): Page<WalletTransaction>

}