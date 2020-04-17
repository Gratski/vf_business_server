package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Wallet
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface WalletRepository: CrudRepository<Wallet, Int> {
}