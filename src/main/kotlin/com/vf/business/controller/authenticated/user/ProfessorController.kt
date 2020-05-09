package com.vf.business.controller.authenticated.user

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.discipline.DisciplineDTO
import com.vf.business.business.dto.discipline.DisciplineListItemDTO
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.locatization.CreateProfessorDetailsDTO
import com.vf.business.business.dto.locatization.LanguageDTO
import com.vf.business.business.dto.locatization.UpdateProfessorDetailsDTO
import com.vf.business.business.dto.notifications.NotificationTypeDTO
import com.vf.business.business.dto.notifications.feed.ListItemFeedNotificationDTO
import com.vf.business.business.dto.notifications.push.NotificationPreferenceDTO
import com.vf.business.business.dto.user.professor.ProfessorDetailsDTO
import com.vf.business.business.dto.user.professor.UpdateProfessorPersonalDetailsDTO
import com.vf.business.business.service.itf.internal.ProfessorDetailsService
import com.vf.business.business.service.itf.internal.ProfessorService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.*
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/professors")
class ProfessorController (
        val userService: UsersService,
        val professorService: ProfessorService,
        val professorDetailsService: ProfessorDetailsService
) {

    @Secured
    @GetMapping("/me/disciplines")
    fun getUserDisciplines(principal: Principal, @RequestParam("offset") offset: Int, @RequestParam("limit") limit: Int): ResourcePage<DisciplineListItemDTO> {
        val professor = userService.getUser(principal) as Professor
        return professorService.getProfessorDisciplines(professor, offset, limit)
    }

    @Secured
    @GetMapping("me/notifications")
    fun getProfessorNotifications(principal: Principal, @RequestParam("page") page: Int, @RequestParam("size") size: Int)
            : ResourcePage<ListItemFeedNotificationDTO> {
        var professor = userService.getUser(principal) as Professor
        return professorService.getProfessorNotifications(professor, page, size)
    }

    /**
     * Gets the languages that are still to be configured to the given professor
     */
    @Secured
    @GetMapping("me/profile-details/available-languages")
    fun getAvailableLanguages(principal: Principal): ResourcePage<LanguageDTO> {
        val professor = (userService.getUser(principal) as Professor)
        return professorService.getAvailableLanguages(LocaleContextHolder.getLocale().toLanguageTag(), professor)
    }

    /**
     * Gets all all the existing language profile details for a given professor
     */
    @Secured
    @GetMapping("me/profile-details/existing-languages")
    fun getProfileDetails(principal: Principal): ResourcePage<LanguageDTO> {
        val professor = (userService.getUser(principal) as Professor)
        return professorService.getExistingLanguages(professor)
    }

    /**
     * Creates a new language profile details for a given professor
     */
    @Secured
    @PostMapping("me/profile-details")
    fun createProfileDetails(principal: Principal, @RequestBody dto: CreateProfessorDetailsDTO): CreateOperationResponseDTO {
        val professor = (userService.getUser(principal) as Professor)
        return professorDetailsService.createProfessorDetails(professor, dto )
    }

    /**
     * Gets a single profile details for a given professor and LanguageID
     */
    @Secured
    @GetMapping("/me/profile-details/{languageId}")
    fun getProfileDetailsByLanguageId(principal: Principal, @PathVariable("languageId") languageId: Int): ProfessorDetailsDTO {
        val professor = (userService.getUser(principal)) as Professor
        return professorService.getProfileDetails(professor, languageId)
    }

    /**
     * Gets all all the existing language profile details for a given professor
     */
    @Secured
    @PutMapping("/me/profile-details/{id}")
    fun updateProfileDetails(principal: Principal, @PathVariable("id") id: Int, @RequestBody dto: UpdateProfessorDetailsDTO) {
        val professor = (userService.getUser(principal) as Professor)
        professorDetailsService.updateProfessorDetails(id, professor, dto )
    }

    /**
     * Updates the personal details for the request professor
     */
    @Secured
    @PutMapping("me/personal-details")
    fun updateProfileDetails(principal: Principal, @RequestBody dto: UpdateProfessorPersonalDetailsDTO) {
        val professor = (userService.getUser(principal) as Professor)
        professorService.updateProfessorProfileDetails(professor, dto)
    }

}