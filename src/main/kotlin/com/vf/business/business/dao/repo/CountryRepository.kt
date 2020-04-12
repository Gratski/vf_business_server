package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Country
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface CountryRepository: CrudRepository<Country, Int> {
}