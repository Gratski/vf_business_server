package com.vf.business

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import org.flywaydb.core.Flyway
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import java.io.FileInputStream
import javax.sql.DataSource

@SpringBootApplication
class Application


    fun main(args: Array<String>) {
        // setup flyway
        val dbUrl = System.getenv("DATABASE_URL")
        if( dbUrl == null ) println("Database url must be set")

        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName("org.postgresql.Driver")

        val tokens = dbUrl.split("//")
        val subTokens = tokens[1].split("@")
        val credentials = subTokens[0].split(":")
        val username = credentials[0]
        val password = credentials[1]
        val url = "jdbc:postgresql://${subTokens[1]}"
        dataSourceBuilder.url(url)
        dataSourceBuilder.username(username)
        dataSourceBuilder.password(password)
        val dataSource = dataSourceBuilder.build()

        val flyway = Flyway.configure().dataSource(dataSource).load()
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
