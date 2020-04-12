package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.UserLanguage
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface UserLanguageRepository: CrudRepository<UserLanguage, Int> {
}