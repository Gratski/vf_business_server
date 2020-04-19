package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.*
import com.vf.business.business.dao.repo.*
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.notifications.NotificationTypeDTO
import com.vf.business.business.dto.notifications.feed.ListItemFeedNotificationDTO
import com.vf.business.business.dto.user.professor.ProfessorDetailsDTO
import com.vf.business.business.dto.user.professor.RegistProfessorAccountDTO
import com.vf.business.business.dto.user.professor.UpdateProfessorProfileDetailsDTO
import com.vf.business.business.exception.MissingArgumentsException
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.internal.FeedNotificationService
import com.vf.business.business.service.itf.internal.ProfessorService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.utils.EmailUtils
import com.vf.business.business.utils.auth.AuthUtils
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.stereotype.Service
import java.util.*
import javax.transaction.Transactional

@Service
class ProfessorServiceImpl(
        val userService: UsersService,
        val feedNotificationsService: FeedNotificationService,
        val professorRepository: ProfessorRepository,
        val professorDetailsRepository: ProfessorDetailsRepository,
        val userLanguageRepo: UserLanguageRepository,
        val languageRepository: LanguageRepository,
        val langContextRepo: LanguageContextRepository,
        val notificationPreferenceRepo: NotificationPreferenceRepository,
        val accessCodeRepo: AccessCodeRepository,
        val countryRepository: CountryRepository,
        val walletRepo: WalletRepository
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

    override fun enableDisableNotification(professor: Professor, notificationType: NotificationTypeDTO, newValue: Boolean) {
        val type = NotificationType.valueOf(notificationType.toString())
        val npOpt = notificationPreferenceRepo.findByNotificationTypeAndUser(type, professor)
        npOpt.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.NOTIFICATION_TYPE))))
        }

        val np = npOpt.get()
        np.enabled = newValue
        notificationPreferenceRepo.save(np)
    }

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun registerNewProfessorAccount(dto: RegistProfessorAccountDTO) {
        if ( hasAllRequiredFields(dto) ) {
            throw MissingArgumentsException(Translator.toLocale(MessageCodes.MISSING_ARGUMENTS))
        }

        // check if this email is already registered
        val userOpt = userService.getUserByEmail(dto.email)
        userOpt.ifPresent {
            throw ResourceConflictException(Translator.toLocale(MessageCodes.EMAIL_ALREADY_EXISTS))
        }

        // check if this professor has an access code given by our team
        val accessCodeOpt = accessCodeRepo.findByEmail(dto.email)
        if ( accessCodeOpt.isEmpty || accessCodeOpt.get().code != dto.accessCode ) {
            UnauthorizedOperationException(
                    Translator.toLocale(MessageCodes.NO_ACCESS_CODE_FOUND)
            )
        }
        val accessCode = accessCodeOpt.get()
        accessCodeRepo.delete(accessCode)

        // fetch needed countries
        val nationality = getCountryById(dto.nationalityCountryId)
        val currentlyLivingIn = getCountryById(dto.currentlyLivingInCountryId)
        val phoneCountry = getCountryById(dto.phoneNumberCountryId)

        val now = Date()

        // create professor account
        val professor = Professor(
            referrals = mutableListOf(),
            firstName= dto.firstName,
            lastName= dto.lastName,
            email= dto.email,
            pwd= AuthUtils.Instance.hashPassword(dto.pwd),
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

        // create wallet
        val wallet = Wallet(
            belongsTo = professor,
            balance = 0.0,
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


    }

    override fun getProfessorNotifications(professor: Professor, page: Int, size: Int): ResourcePage<ListItemFeedNotificationDTO> {
        TODO("Not yet implemented")
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

    private fun hasAllRequiredFields(dto: UpdateProfessorProfileDetailsDTO): Boolean {
        return dto.firstName.isNotBlank() && dto.lastName.isNotBlank() && dto.phoneNumber.isNotBlank() && dto.VAT.isNotBlank()
    }

}