package com.vf.business

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.flywaydb.core.Flyway
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import java.io.FileInputStream

@SpringBootApplication
@EnableJpaRepositories(basePackages = ["com.vf.business.business.dao.repo"])
class Application


    fun main(args: Array<String>) {
        // setup flyway
        val dbUrl = System.getenv("DB_URL")
        if( dbUrl == null ) println("Database url must be set")

        val dbUser = System.getenv("DB_USER")
        if( dbUser == null ) println("Database user must be set")

        val dbPwd = System.getenv("DB_PWD")
        if( dbPwd == null ) println("Database pwd must be set")

        val flyway = Flyway.configure().dataSource(dbUrl, dbUser, dbPwd).load()
        flyway.baseline()
        flyway.migrate()

        // setup firebase
        val serviceAccount = FileInputStream("vfit-ee4bc-firebase-adminsdk-nztl6-6d72dda637.json")
        val options: FirebaseOptions = FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://vfit-ee4bc.firebaseio.com")
                .build()
        FirebaseApp.initializeApp(options)

        SpringApplication.run(Application::class.java, *args)
    }
