package com.vf.business.service.impl

import com.vf.business.dao.models.Student
import com.vf.business.dao.repo.StudentRepository
import com.vf.business.dao.repo.UsersRepository
import com.vf.business.dto.user.StudentDTO
import org.springframework.stereotype.Service
import com.vf.business.service.exception.ResourceConflictException
import com.vf.business.service.exception.ResourceNotFoundException
import com.vf.business.service.itf.StudentService
import java.util.*

@Service
class StudentServiceImpl(userRepo: UsersRepository, val studentRepo: StudentRepository) : UsersServiceImpl<Student>(userRepo), StudentService {

    override fun createStudent(s: StudentDTO): Int {

        var studentId: Int = -1
        this.getUserByEmail(s.email!!).ifPresentOrElse({
            throw ResourceConflictException()
        }, {
            val now = Date()
            val student = Student(firstName = s.firstName, lastName = s.lastName, email = s.email, pwd = s.pwd,
                    createdAt = now, updatedAt = now)
            studentRepo.save(student)
            studentId = student.id!!
        })
        return studentId;
    }

    override fun getStudent(id: Int): StudentDTO {
        var result: StudentDTO = StudentDTO(firstName = "", lastName =  "", email =  "")
        val opt = studentRepo.findById(id)
        if (opt.isPresent) return Student.ModelMapper.from(opt.get()) else throw ResourceNotFoundException()
    }

}