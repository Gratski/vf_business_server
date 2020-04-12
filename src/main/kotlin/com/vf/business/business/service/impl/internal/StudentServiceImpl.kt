package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.dao.repo.StudentRepository
import com.vf.business.business.dao.repo.UsersRepository
import com.vf.business.business.dto.user.StudentDTO
import com.vf.business.business.events.EventLabelsEnum
import com.vf.business.business.events.EventTypeEnum
import org.springframework.stereotype.Service
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.exception.UnauthorizedOperationException
import com.vf.business.business.service.itf.external.messaging.MessagingService
import com.vf.business.business.service.itf.internal.StudentService
import com.vf.business.business.utils.StudentMapper
import com.vf.business.common.i18n.MessageCodes
import com.vf.business.config.i18n.Translator
import java.util.*

@Service
class StudentServiceImpl(
        userRepo: UsersRepository,
        val studentRepo: StudentRepository,
        val messagingService: MessagingService
        ) : UsersServiceImpl<Student>(userRepo), StudentService {

    override fun createStudent(s: StudentDTO): Int {

        var studentId: Int = -1
        this.getUserByEmail(s.email!!).ifPresent {
            throw ResourceConflictException()
        }

        val now = Date()
        val student = Student(firstName = s.firstName, lastName = s.lastName, email = s.email, pwd = s.pwd, countryCode = s.countryCode,
                createdAt = now, updatedAt = now)
        studentRepo.save(student)
        studentId = student.id!!

        return studentId;
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