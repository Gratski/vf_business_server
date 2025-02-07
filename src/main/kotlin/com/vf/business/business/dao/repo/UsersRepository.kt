package com.vf.business.business.dao.repo

import com.vf.business.business.dao.models.User
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersRepository : CrudRepository<User, Int> {

    fun findByEmail(email: String): Optional<User>

}