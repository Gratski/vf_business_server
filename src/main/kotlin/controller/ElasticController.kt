package controller

import dao.models.UserModel
import dto.ElasticStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import service.itf.IElasticService
import service.itf.IMongoService
import java.util.*

@RestController
@RequestMapping("elastic")
class ElasticController (val service: IElasticService, val mongoService: IMongoService) {

    @GetMapping("status")
    fun getElasticStatus(@RequestParam(value = "name", defaultValue = "World") name: String): ElasticStatus =
            service.getElasticStatus()

    @GetMapping("users")
    fun getUsers(@RequestParam(value = "name", defaultValue = "World") name: String): UserModel =
            mongoService.findUser("JohnD").orElse(UserModel())

    @GetMapping("create")
    fun create(@RequestParam(value = "name", defaultValue = "World") name: String) =
            mongoService.createUser(UserModel(id = null, name = "JohnD"))


}