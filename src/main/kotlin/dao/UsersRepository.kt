package dao

import dao.models.UserModel
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface UsersRepository : CrudRepository<UserModel, String> {
    /**
     * Query method declaring a nullable return type that allows to return null values.
     */
    fun findOneOrNoneByName(name: String): Optional<UserModel>
}