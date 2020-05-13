package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.CurrencyModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CurrencyRepository: CrudRepository<CurrencyModel, Int> {
    fun findByDesignation(designation: String): Optional<CurrencyModel>
}