package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dao.models.UserLanguage
import com.vf.business.business.dao.repo.*
import com.vf.business.business.dto.user.student.CreateStudentDTO
import com.vf.business.business.dto.user.student.StudentDTO
import com.vf.business.business.events.EventLabelsEnum
import com.vf.business.business.events.EventTypeEnum
import com.vf.business.business.exception.MissingArgumentsException
import org.springframework.stereotype.Service
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.external.messaging.MessagingService
import com.vf.business.business.service.itf.internal.StudentService
import com.vf.business.business.utils.auth.AuthUtils
import com.vf.business.business.utils.mapper.StudentMapper
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import java.util.*
import javax.transaction.Transactional

@Service
class StudentServiceImpl(
        userRepo: UsersRepository,
        val studentRepo: StudentRepository,
        val messagingService: MessagingService,
        val languageRepo: LanguageRepository,
        val countryRepo: CountryRepository,
        val userLangRepo: UserLanguageRepository
        ) : UsersServiceImpl<Student>(userRepo), StudentService {

    @Transactional
    override fun createStudent(s: CreateStudentDTO): Int {
        var studentOpt = this.getUserByEmail(s.email!!);
        studentOpt.ifPresent {
            throw ResourceConflictException(Translator.toLocale(MessageCodes.EMAIL_ALREADY_EXISTS))
        }

        // fetch living in country
        val livingInOpt = countryRepo.findById(s.livingIn)
        livingInOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.USER_UNEXISTING_LIVING_IN)
            )
        }
        val livingIn = livingInOpt.get()

        // fetch nationality country
        val nationalityOpt = countryRepo.findById(s.livingIn)
        livingInOpt.orElseThrow {
            throw ResourceNotFoundException(
                    Translator.toLocale(MessageCodes.USER_UNEXISTING_NATIONALITY)
            )
        }
        val nationality = nationalityOpt.get()

        // fetch languages spoken
        val spokenLanguages = languageRepo.findAllById(s.spokenLanguages).asSequence().toMutableList()
        if( spokenLanguages.size == 0 ) {
            throw MissingArgumentsException(
                    Translator.toLocale(MessageCodes.USER_SPOKEN_LANGUAGES_EMPTY)
            )
        }

        // check if the given phone country exists
        val phoneCountryOpt = countryRepo.findById(s.phoneNumberCountryId)
        phoneCountryOpt.orElseThrow {
            throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.COUNTRY))))
        }
        val phoneNumberCountry = phoneCountryOpt.get()

        val now = Date()
        val student = Student(
                firstName = s.firstName,
                lastName = s.lastName,
                email = s.email,
                pwd = AuthUtils.Instance.hashPassword(s.pwd),
                gender = s.gender,
                birthday = s.birthday,
                phoneNumber = s.phoneNumber,
                phoneNumberCountry = phoneNumberCountry,
                livingIn = livingIn,
                nationality = nationality,
                spokenLanguages = mutableListOf(),
                createdAt = now, updatedAt = now,
                //TODO: this will cause an app error if not fixed
                notificationPreferences = mutableListOf())
        studentRepo.save(student)

        val spokenUserLanguages = mutableListOf<UserLanguage>()
        spokenLanguages.forEach {
            spokenUserLanguages.add(UserLanguage(
                    language = it,
                    user = student,
                    createdAt = now,
                    updatedAt = now
            ))
        }

        // save all user spoken languages
        userLangRepo.saveAll(spokenUserLanguages)

        return student.id!!;
    }

    override fun getStudent(id: Int): StudentDTO = StudentMapper.Mapper.map(findStudentById(id))

    override fun muteStudent(professor: Professor, id: Int) =
            muteUnmuteStudent(id, professor, EventTypeEnum.MUTE, EventLabelsEnum.MUTE_SINGLE)

    override fun unmuteStudent(professor: Professor, id: Int) =
            muteUnmuteStudent(id, professor, EventTypeEnum.UNMUTE, EventLabelsEnum.UNMUTE_SINGLE)

    private fun muteUnmuteStudent(id: Int, professor: Professor, eventType: EventTypeEnum, label: EventLabelsEnum) {
        val student = findStudentById(id)
        if( student.currentlyAttending?.id != professor.currentlyGiving?.id ) {
            throw UnauthorizedOperationException(Translator.toLocale(MessageCodes.UNAUTHORIZED_OPERATION))
        }

        // notify user
        if (student.fcmToken != null)
            messagingService.sendLabeledMessageToSingleUser(eventType, label, "", student.fcmToken!!)
    }

    private fun findStudentById(id: Int): Student {
        val opt = studentRepo.findById(id)
        return if (opt.isPresent) opt.get()
        else throw ResourceNotFoundException(Translator.toLocale(MessageCodes.UNEXISTING_RESOURCE, arrayOf(Translator.toLocale(MessageCodes.STUDENT))))
    }

}