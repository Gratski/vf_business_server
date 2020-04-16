package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.AccessCode
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface AccessCodeRepository: CrudRepository<AccessCode, Int> {

    fun findByEmail(email: String): Optional<AccessCode>

}