package com.vf.business.business.service.impl.internal

import com.vf.business.business.dao.models.User
import com.vf.business.business.dao.repo.UsersRepository
import com.vf.business.business.exception.ResourceNotFoundException
import com.vf.business.business.service.itf.internal.UsersService
import com.vf.business.business.utils.auth.AuthUtils
import org.springframework.security.authentication.BadCredentialsException
import java.security.Principal
import java.util.Optional

open class UsersServiceImpl<T: User>(val userRepo: UsersRepository) : UsersService {

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

    override fun deleteUser(id: Int) {
        val userOpt = getUser(id)
        userOpt.ifPresent { u ->
            run {
                userRepo.delete(u)
            }
        }
        throw ResourceNotFoundException()
    }

}