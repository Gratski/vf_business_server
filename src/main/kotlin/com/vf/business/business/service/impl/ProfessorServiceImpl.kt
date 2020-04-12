package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.Country
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.repo.CountryRepository
import com.vf.business.business.dao.repo.ProfessorRepository
import com.vf.business.business.dto.user.professor.UpdateProfessorProfileDetailsDTO
import com.vf.business.business.exception.MissingArgumentsException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.ProfessorService
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.stereotype.Service
import java.util.*

@Service
class ProfessorServiceImpl(
        val professorRepository: ProfessorRepository,
        val countryRepository: CountryRepository
): ProfessorService {

    override fun updateProfessorProfileDetails(professor: Professor, dto: UpdateProfessorProfileDetailsDTO) {
        if ( !hasAllRequiredFields(dto) ) {
            throw MissingArgumentsException(Translator.toLocale(MessageCodes.MISSING_ARGUMENTS))
        }

        // check if has to update phone number code
        if ( dto.phoneNumberCountryId != professor.phoneNumberCountry?.id ) {
            professor.phoneNumberCountry = getCountryById(dto.phoneNumberCountryId)
        }

        // check if has to update nationality country
        if ( dto.nationalityCountryId != professor.nationality?.id ) {
            professor.nationality = getCountryById(dto.nationalityCountryId)
        }

        professor.firstName = dto.firstName
        professor.lastName = dto.lastName
        professor.birthday = dto.birthday
        professor.gender = dto.gender
        professor.updatedAt = Date()
        professor.phoneNumber = dto.phoneNumber
        professor.VAT = dto.VAT

        professorRepository.save(professor)

    }

    private fun getCountryById(countryId: Int) : Country {
        val countryOpt = countryRepository.findById(countryId)
        countryOpt.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(
                    MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.COUNTRY))))
        }
        return countryOpt.get()
    }

    private fun hasAllRequiredFields(dto: UpdateProfessorProfileDetailsDTO): Boolean {
        return dto.firstName.isNotBlank() && dto.lastName.isNotBlank() && dto.phoneNumber.isNotBlank() && dto.VAT.isNotBlank()
    }

}