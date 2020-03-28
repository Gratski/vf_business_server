package com.vf.business.business.service.impl

import com.vf.business.business.dao.models.User
import com.vf.business.business.dao.repo.UsersRepository
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.UsersService
import java.util.Optional

open class UsersServiceImpl<T: User>(val userRepo: UsersRepository) : UsersService {

    override fun getUser(id: Int): Optional<User> =
        userRepo.findById(id)

    override fun getUserByEmail(email: String): Optional<User> =
        userRepo.findByEmail(email)

    override fun deleteUser(id: Int) {
        getUser(id).ifPresentOrElse( {u -> {
            userRepo.delete(u)
        }}, {
            throw ResourceNotFoundException()
        })
    }

}