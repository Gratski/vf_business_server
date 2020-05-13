package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.*
import com.vf.business.business.dao.models.wallet.Wallet
import com.vf.business.business.dao.repo.*
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.category.CategoryDTO
import com.vf.business.business.dto.discipline.DisciplineListItemDTO
import com.vf.business.business.dto.locatization.LanguageDTO
import com.vf.business.business.dto.notifications.feed.ListItemFeedNotificationDTO
import com.vf.business.business.dto.registration.RegistrationResponseDTO
import com.vf.business.business.dto.user.professor.*
import com.vf.business.business.exception.MissingArgumentsException
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.internal.*
import com.vf.business.business.utils.EmailUtils
import com.vf.business.business.utils.auth.AuthUtils
import com.vf.business.business.utils.mapper.DisciplineMapper
import com.vf.business.business.utils.mapper.ProfessorDetailsMapper
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.context.i18n.LocaleContextHolder
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional
import kotlin.math.floor

@Service
class ProfessorServiceImpl(
        val userService: UsersService,
        val professorRepository: ProfessorRepository,
        val professorDetailsRepository: ProfessorDetailsRepository,
        val userLanguageRepo: UserLanguageRepository,
        val languageRepository: LanguageRepository,
        val langContextRepo: LanguageContextRepository,
        val notificationPreferenceRepo: NotificationPreferenceRepository,
        val accessCodeRepo: AccessCodeRepository,
        val countryRepository: CountryRepository,
        val walletRepo: WalletRepository,
        val communicationsService: CommunicationsService,
        val languageService: LanguageService,
        val languageContextRepository: LanguageContextRepository,
        val disciplineRepo: DisciplineRepository,
        val categoryTranslationRepository: CategoryTranslationRepository,
        val currencyRepository: CurrencyRepository
): ProfessorService {

    override fun updateProfessorProfileDetails(professor: Professor, dto: UpdateProfessorPersonalDetailsDTO) {
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

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun registerNewProfessorAccount(dto: RegistProfessorAccountDTO) {
        if ( !hasAllRequiredFields(dto) ) {
            throw MissingArgumentsException(Translator.toLocale(MessageCodes.MISSING_ARGUMENTS))
        }

        // check if this email is already registered
        val userOpt = userService.getUserByEmail(dto.email)
        userOpt.ifPresent {
            throw ResourceConflictException(Translator.toLocale(MessageCodes.EMAIL_ALREADY_EXISTS))
        }

        val now = Date()

        // check if this professor has an access code given by our team
        val generatedAccessCode = AuthUtils.Instance.generateRandomString(5)
        val accessCode = AccessCode(code = generatedAccessCode, confirmed = false, email = dto.email, createdAt = now, updatedAt = now)
        accessCodeRepo.save(accessCode)

        // fetch needed countries
        val nationality = getCountryById(dto.nationalityCountryId)
        val currentlyLivingIn = getCountryById(dto.currentlyLivingInCountryId)
        val phoneCountry = getCountryById(dto.phoneNumberCountryId)

        // create professor account
        val professor = Professor(
            referrals = mutableListOf(),
            firstName= dto.firstName,
            lastName= dto.lastName,
            email= dto.email,
            pwd= AuthUtils.Instance.hashPassword(generatedAccessCode),
            gender= dto.gender,
            birthday= dto.birthday,
            phoneNumberCountry= phoneCountry,
            phoneNumber= dto.phoneNumber,
            nationality= nationality,
            livingIn= currentlyLivingIn,
            spokenLanguages= mutableListOf(),
            VAT = dto.vat,
            languageContexts = mutableListOf(),
            cancellationsNumber = 0,
            fcmToken = dto.fcmToken,
            notificationPreferences = mutableListOf(),
            createdAt = now,
            updatedAt = now
        )
        professorRepository.save(professor)

        // fetch default currency
        val currencyOpt = currencyRepository.findByDesignation("US Dollar");
        currencyOpt.orElseThrow{
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.CURRENCY)))
            )
        }

        // create wallet
        val wallet = Wallet(
                belongsTo = professor,
                balance = 0.0,
                currency =  currencyOpt.get(),
                createdAt = now,
                updatedAt = now
        )
        walletRepo.save(wallet)

        // create all needed notification preferences
        createDefaultNotificationPreferencesList(professor)

        // create default speaking language
        createDefaultSpeakingLanguage(professor, dto.nativeSpeakingLanguage)

        // create default language context
        createDefaultContextLanguage(dto.professorDetails, professor, dto.nativeSpeakingLanguage)

        // send the welcome email to professor account
        communicationsService.sendWelcomeEmailToProfessor("${dto.firstName} ${dto.lastName}", professor.email!!, generatedAccessCode, dto.nativeSpeakingLanguage)
    }

    override fun getProfessorNotifications(professor: Professor, page: Int, size: Int): ResourcePage<ListItemFeedNotificationDTO> {
        TODO("Not yet implemented")
    }

    @Transactional
    override fun registValidationProfessor(dto: ProfessorRegistValidationDTO): RegistrationResponseDTO {
        // check if this email is already registered
        val userOpt = userService.getUserByEmail(dto.email)
        userOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE,
                            arrayOf(Translator.toLocale(MessageCodes.USER))))
        }

        // check if this professor has an access code given by our team
        val accessCodeOpt: Optional<AccessCode> = accessCodeRepo.findByEmail(dto.email)
        if ( !accessCodeOpt.isPresent ) {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.NO_ACCESS_CODE_FOUND)
            )
        } else if( accessCodeOpt.get().confirmed ) {
            throw UnauthorizedOperationException(
                    Translator.toLocale(MessageCodes.ACCESS_CODE_ALREADY_CONFIRMED)
            )
        } else if ( accessCodeOpt.get().code != dto.accessCode ) {
            throw UnauthorizedOperationException(
                    Translator.toLocale(MessageCodes.INVALID_ACCESS_CODE)
            )
        }
        val accessCode = accessCodeOpt.get()
        accessCode.confirmed = true
        accessCodeRepo.save(accessCode);

        // update user password
        val user = userOpt.get()
        user.password = AuthUtils.Instance.hashPassword(dto.password)
        user.active = true
        userService.updateUser(user)

        return RegistrationResponseDTO(id = user.id!!)
    }

    override fun getAvailableLanguages(langCode: String, professor: Professor): ResourcePage<LanguageDTO> =
        languageService.getAvailableLanguagesForProfessor(langCode, professor)

    override fun getExistingLanguages(professor: Professor): ResourcePage<LanguageDTO> =
        languageService.getExistingLanguagesOfProfessor(LocaleContextHolder.getLocale().toLanguageTag(), professor)

    override fun updateLanguageProfile(professor: Professor, dto: UpdateLanguageProfileDTO) {
        val languageContextOpt = languageContextRepository.findById(dto.id)
        languageContextOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.PROFESSOR_DETAILS)))
            )
        }
        val langContext = languageContextOpt.get()
        langContext.professorDetails?.designation = dto.designation
        langContext.professorDetails?.description = dto.description
        langContext.professorDetails?.quote = dto.quote
        languageContextRepository.save(langContext)
    }

    override fun getProfileDetails(professor: Professor, languageId: Int): ProfessorDetailsDTO {
        val pdOpt = professorDetailsRepository.findProfessorDetailsByProfessorAndLanguage(languageId, professor)
        pdOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.PROFESSOR_DETAILS)))
            )
        }

        // verify if this professor details belongs to the requester
        if ( professor.id != pdOpt.get().languageContext.professor.id ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }

        return ProfessorDetailsMapper.Mapper.map(pdOpt.get())
    }

    override fun getProfessorDisciplines(professor: Professor, offset: Int, limit: Int): ResourcePage<DisciplineListItemDTO> {
        var pageNumber = (offset / limit) + (offset % limit)
        val sort = Sort.by(Sort.Direction.DESC, "id")
        val pageReq = PageRequest.of(pageNumber, limit, sort)
        val page = this.disciplineRepo.findByProfessor(professor, pageReq)
        val resultList = mutableListOf<DisciplineListItemDTO>()
        page.forEach {
            resultList.add(DisciplineListItemDTO(
                id = it.id!!,
                languageId = it.languageContext.language.id!!,
                designation= it.designation!!,
                difficultyLevel= it.difficultyLevel,
                duration = it.duration,
                isActive= it.active!!,
                languageCode= it.languageContext.language.code,
                pictureUrl= it.imageUrl,
                status = it.status
            ))
        }

        return ResourcePage(total = page.totalElements, items = resultList)
    }

    override fun getProfessorProfile(id: Int, languageId: Int): ProfessorProfileDTO {
        // get professor
        val profOpt = professorRepository.findById(id)
        profOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.PROFESSOR_DETAILS)))
            )
        }
        val professor = profOpt.get()

        // get professor details
        val profDetailsOpt = professorDetailsRepository.findProfessorDetailsByProfessorAndLanguage(languageId, professor)
        profDetailsOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.PROFESSOR_DETAILS)))
            )
        }
        val professorDetails = profDetailsOpt.get()

        // get category translations for those this professor has disciplines already created
        val categories = categoryTranslationRepository.findByProfessorAndLanguageId(professor, languageId)
        val teaches = mutableListOf<CategoryDTO>()
        categories.forEach {
            teaches.add(
                    CategoryDTO(
                        id = it.category.id,
                        designation = it.designation,
                        description = it.description,
                        icon = it.category.icon,
                        picture = null,
                        createdAt = it.category.createdAt,
                        updatedAt = it.category.updatedAt
                    )
            )
        }

        // prepare and send result
        return ProfessorProfileDTO(
                id = professor.id!!,
                firstName = professor.firstName!!,
                lastName = professor.lastName!!,
                pictureUrl = professor.pictureUrl,
                quote = professorDetails.quote,
                about = professorDetails.description,
                teaches = teaches
        )
    }

    private fun createDefaultSpeakingLanguage(professor: Professor, languageCode: String) {
        val language = languageRepository.findFirstByCode(languageCode)
        language.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE,
                            arrayOf(Translator.toLocale(MessageCodes.LANGUAGE))))
        }

        val now = Date()
        val userLang = UserLanguage(
            language = language.get(),
            user = professor,
            createdAt = now,
            updatedAt = now
        )
        userLanguageRepo.save(userLang)
    }

    private fun createDefaultContextLanguage(detailsDto: ProfessorDetailsDTO, professor: Professor, languageCode: String) {
        val language = languageRepository.findFirstByCode(languageCode)
        language.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE,
                            arrayOf(Translator.toLocale(MessageCodes.LANGUAGE))))
        }
        val now = Date()
        val langContext = LanguageContext(
            professor = professor,
            language = language.get(),
            isNative = true,
            professorDetails = null,
            disciplines = mutableListOf(),
            createdAt = now,
            updatedAt = now
        )
        langContextRepo.save(langContext)

        val details = ProfessorDetails(
            languageContext = langContext,
            designation = detailsDto.designation,
            description = detailsDto.description,
            quote = detailsDto.quote,
            createdAt = now,
            updatedAt = now
        )
        professorDetailsRepository.save(details)
    }

    private fun createDefaultNotificationPreferencesList(professor: Professor){
        val now = Date()
        val types = listOf<NotificationType>(NotificationType.GENERAL, NotificationType.REMINDER, NotificationType.SYSTEM)
        types.forEach {
            notificationPreferenceRepo.save(NotificationPreference(
                    notificationType = it,
                    user = professor,
                    enabled = true,
                    createdAt = now,
                    updatedAt = now))
        }
    }

    private fun hasAllRequiredFields(dto: RegistProfessorAccountDTO): Boolean =
        dto.vat.isNotBlank() && dto.email.isNotBlank() && EmailUtils().isValidEmail(dto.email)
                && dto.firstName.isNotBlank() && dto.lastName.isNotBlank()
                && dto.phoneNumber.isNotBlank()


    private fun getCountryById(countryId: Int) : Country {
        val countryOpt = countryRepository.findById(countryId)
        countryOpt.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(
                    MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.COUNTRY))))
        }
        return countryOpt.get()
    }

    private fun hasAllRequiredFields(dto: UpdateProfessorPersonalDetailsDTO): Boolean {
        return dto.firstName.isNotBlank() && dto.lastName.isNotBlank() && dto.phoneNumber.isNotBlank() && dto.VAT.isNotBlank()
    }

}