package com.vf.business.dao.repo

import com.vf.business.dao.models.Student
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface StudentRepository : CrudRepository<Student, Int>