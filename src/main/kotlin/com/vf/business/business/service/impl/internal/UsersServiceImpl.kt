package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.NotificationType
import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.User
import com.vf.business.business.dao.repo.NotificationPreferenceRepository
import com.vf.business.business.dao.repo.UsersRepository
import com.vf.business.business.dto.ChangePictureResponseDTO
import com.vf.business.business.dto.ResourcePage
import com.vf.business.business.dto.notifications.NotificationTypeDTO
import com.vf.business.business.dto.notifications.push.NotificationPreferenceDTO
import com.vf.business.business.dto.user.UpdatedUserDetailsDTO
import com.vf.business.business.exception.MissingArgumentsException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.CountriesService
import com.vf.business.business.service.itf.internal.StorageService
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.utils.auth.AuthUtils
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.web.multipart.MultipartFile
import java.security.Principal
import java.util.Optional

open class UsersServiceImpl<T: User>(
        private val userRepo: UsersRepository,
        val countriesService: CountriesService,
        val notificationPreferenceRepo: NotificationPreferenceRepository,
        val storageService: StorageService
        ) : UsersService {

    override fun getUser(id: Int): Optional<User> =
        userRepo.findById(id)

    override fun getUser(principal: Principal): User {
        val id = AuthUtils.Instance.extractUserId(principal)
        val userOpt = getUser(id)
        userOpt.orElseThrow {
            throw BadCredentialsException("This user token is not authorized")
        }
        return userOpt.get()
    }

    override fun getUserByEmail(email: String): Optional<User> =
        userRepo.findByEmail(email)

    override fun updateUser(user: User) {
        userRepo.save(user)
    }

    override fun updateUserPersonalDetails(user: User, details: UpdatedUserDetailsDTO) {
        validateRequiredFields(details)

        user.firstName = details.firstName
        user.lastName = details.lastName
        user.gender = details.gender
        user.phoneNumber = details.phoneNumber
        user.birthday = details.birthday

        val nationalityCountry = countriesService.getCountry(details.nationalityCountryId)
        user.nationality = nationalityCountry

        updateUser(user)
    }

    override fun deleteUser(id: Int) {
        val userOpt = getUser(id)
        userOpt.ifPresent { u ->
            run {
                userRepo.delete(u)
            }
        }
        throw ResourceNotFoundException()
    }

    override fun getNotificationPreferences(user: User): ResourcePage<NotificationPreferenceDTO> {
        val np = notificationPreferenceRepo.findByUser(user)
        val resultList = mutableListOf<NotificationPreferenceDTO>()
        np.forEach {
            val pref = NotificationPreferenceDTO(
                    id = it.id!!,
                    type = it.notificationType,
                    isActive = it.enabled!!
            )
            resultList.add(pref)
        }
        return ResourcePage(total = np.size.toLong(), items = resultList)
    }

    override fun enableDisableNotification(user: User, notificationType: NotificationTypeDTO, isEnabled: Boolean) {
        val type = NotificationType.valueOf(notificationType.toString())
        val npOpt = notificationPreferenceRepo.findByNotificationTypeAndUser(type, user)
        npOpt.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.NOTIFICATION_TYPE))))
        }

        val np = npOpt.get()
        np.enabled = isEnabled
        notificationPreferenceRepo.save(np)
    }

    override fun changeProfilePicture(user: User, file: MultipartFile): ChangePictureResponseDTO {
        // upload new picture
        val storePictureResponse = storageService.storePicture(file)

        // delete the old picture
        if ( user.pictureUrl != null ) {
            storageService.removePicture(user.pictureUrl);
        }

        user.pictureUrl = storePictureResponse.url
        userRepo.save(user)
        return ChangePictureResponseDTO(user.pictureUrl!!)
    }

    private fun validateRequiredFields(details: UpdatedUserDetailsDTO) {
        if ( details.firstName.isBlank() || details.lastName.isBlank() || details.phoneNumber.isBlank() ) {
            throw MissingArgumentsException(
                    Translator.toLocale(MessageCodes.MISSING_ARGUMENTS)
            )
        }
    }

}