package com.vf.business.controller.authenticated

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.locatization.LanguageDTO
import com.vf.business.business.service.itf.internal.LanguageService
import org.springframework.security.access.annotation.Secured
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.security.Principal

@RestController
@RequestMapping("\${api.version}/languages")
class LanguagesController(
        val languageService: LanguageService
) {

    @GetMapping("/{lang}")
    fun getLanguages(@PathVariable("lang") lang: String): ResourcePage<LanguageDTO> {
        return languageService.getLanguagesByLanguageCode(lang)
    }

}