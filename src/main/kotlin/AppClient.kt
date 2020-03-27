import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories

@SpringBootApplication
@ComponentScan("controller", "service", "dao")
@EnableMongoRepositories
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}