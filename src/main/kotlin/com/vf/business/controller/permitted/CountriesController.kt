package com.vf.business.controller.permitted

import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.locatization.CountryDTO
import com.vf.business.business.service.itf.internal.CountriesService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("\${api.version}/countries")
class CountriesController(
        val countriesService: CountriesService
) {

    @GetMapping("/{langCode}")
    fun getCountries(@PathVariable("langCode") langCode: String): ResourcePage<CountryDTO> {
        return countriesService.getCountries(langCode)
    }

}