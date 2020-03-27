package service.impl

import dao.UsersRepository
import dao.models.UserModel
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import service.itf.IMongoService
import java.util.*

@Service
class MongoServiceImpl @Autowired constructor(val repo: UsersRepository) : IMongoService{

    override fun createUser(user: UserModel): UserModel =
            repo.save(user)

    override fun findUser(name: String): Optional<UserModel> =
            repo.findOneOrNoneByName(name)
}