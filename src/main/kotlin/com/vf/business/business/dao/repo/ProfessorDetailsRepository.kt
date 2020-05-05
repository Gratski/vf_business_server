package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.ProfessorDetails
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface ProfessorDetailsRepository: CrudRepository<ProfessorDetails, Int> {

    @Query("SELECT PD FROM ProfessorDetails PD, LanguageContext LC, Language L WHERE L.id = :languageId AND LC.language = L AND LC.professor = :professor AND PD.languageContext = LC")
    fun findProfessorDetailsByProfessorAndLanguage(@Param("languageId") languageId: Int, professor: Professor): Optional<ProfessorDetails>

}