package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.Student
import com.vf.business.business.dao.repo.StudentRepository
import com.vf.business.business.dao.repo.UsersRepository
import com.vf.business.business.dto.user.StudentDTO
import org.springframework.stereotype.Service
import com.vf.business.business.exception.ResourceConflictException
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.StudentService
import java.util.*

@Service
class StudentServiceImpl(userRepo: UsersRepository, val studentRepo: StudentRepository) : UsersServiceImpl<Student>(userRepo), StudentService {

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

    override fun getStudent(id: Int): StudentDTO {
        val opt = studentRepo.findById(id)
        return if (opt.isPresent) Student.ModelMapper.from(opt.get()) else throw ResourceNotFoundException()
    }

}