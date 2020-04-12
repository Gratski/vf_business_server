package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Language
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface LanguageRepository: CrudRepository<Language, Int> {
}