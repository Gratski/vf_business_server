package service.itf

import dao.models.UserModel
import java.util.*

interface IMongoService {
    fun createUser(user: UserModel): UserModel;
    fun findUser(name: String): Optional<UserModel>;
}