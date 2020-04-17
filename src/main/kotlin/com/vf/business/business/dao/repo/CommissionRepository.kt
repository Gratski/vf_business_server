package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Commission
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface CommissionRepository: CrudRepository<Commission, Int> {

    @Query("SELECT c FROM Commission c " +
            "WHERE c.from >= :qty AND c.until <= :qty")
    fun findCommissionByAttendantsQuantity(@Param("qty") qty: Int): Optional<Commission>

}