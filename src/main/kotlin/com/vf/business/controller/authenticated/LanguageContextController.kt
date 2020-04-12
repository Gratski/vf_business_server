package com.vf.business.controller.authenticated

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dto.general.CreateOperationResponseDTO
import com.vf.business.business.dto.locatization.CreateLanguageContextDTO
import com.vf.business.business.service.itf.internal.LanguageContextService
import com.vf.business.business.service.itf.internal.UsersService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/language-contexts")
class LanguageContextController(
        val usersService: UsersService,
        val langContextService: LanguageContextService
) {

    @PostMapping("")
    fun createDiscipline(principal: Principal, @RequestBody dto: CreateLanguageContextDTO): CreateOperationResponseDTO {
        val professor = (usersService.getUser(principal) as Professor)
        return langContextService.createLanguageContext(professor, dto)
    }

}