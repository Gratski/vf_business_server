package com.vf.business.business.utils.mapper

import com.vf.business.business.dao.models.Country
import com.vf.business.business.dto.locatization.CountryDTO

class CountryMapper {

    object Mapper {

        fun map(country: Country): CountryDTO =
            CountryDTO(
                    id= country.id,
                    countryCode = country.countryCode,
                    countryName = country.countryName
            )
        fun map(dto: CountryDTO): Country =
                Country(
                        id = dto.id,
                        countryCode = dto.countryCode,
                        countryName = dto.countryName,
                        spokenLanguages = mutableListOf()
                )
    }

}