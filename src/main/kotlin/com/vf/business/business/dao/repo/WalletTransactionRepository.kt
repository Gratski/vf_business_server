package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.WalletTransaction
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletTransactionRepository: CrudRepository<WalletTransaction, Int> {
}