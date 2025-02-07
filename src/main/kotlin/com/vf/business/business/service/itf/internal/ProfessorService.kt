package com.vf.business.business.service.itf.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineListItemDTO
import com.vf.business.business.dto.locatization.LanguageDTO
import com.vf.business.business.dto.notifications.NotificationTypeDTO
import com.vf.business.business.dto.notifications.feed.ListItemFeedNotificationDTO
import com.vf.business.business.dto.notifications.push.NotificationPreferenceDTO
import com.vf.business.business.dto.registration.RegistrationResponseDTO
import com.vf.business.business.dto.user.professor.*

interface ProfessorService {

    /**
     * Updates professor profile details
     */
    fun updateProfessorProfileDetails(professor: Professor, dto: UpdateProfessorPersonalDetailsDTO)

    /**
     * Creates a new professor account
     */
    fun registerNewProfessorAccount(dto: RegistProfessorAccountDTO)

    /**
     * Gets a page of notifications belonging to the given professor account
     */
    fun getProfessorNotifications(professor: Professor, page: Int, size: Int): ResourcePage<ListItemFeedNotificationDTO>

    /**
     * Validates a professor regist
     * This is the last step of registration for a professor
     */
    fun registValidationProfessor(dto: ProfessorRegistValidationDTO): RegistrationResponseDTO

    /**
     * Gets the languages that are not configured by the given professor yet
     */
    fun getAvailableLanguages(langCode: String, professor: Professor): ResourcePage<LanguageDTO>

    /**
     * Gets the languages that are already configured for the given professor
     */
    fun getExistingLanguages(professor: Professor): ResourcePage<LanguageDTO>

    /**
     * Updates the profile of a given professor to a certain language
     */
    fun updateLanguageProfile(professor: Professor, dto: UpdateLanguageProfileDTO)

    /**
     * Gets a single profile details based on its ID
     */
    fun getProfileDetails(professor: Professor, id: Int): ProfessorDetailsDTO

    /**
     * Gets a set of disciplines owned by a given professor
     */
    fun getProfessorDisciplines(professor: Professor, offset: Int, limit: Int): ResourcePage<DisciplineListItemDTO>

    /**
     * Gets a professor profile considering the given language
     * This request is only considered to be valid if the given professor
     * has a profile registered in the given language
     */
    fun getProfessorProfile(id: Int, languageId: Int): ProfessorProfileDTO

}