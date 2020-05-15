package com.vf.business.config.db

import org.springframework.boot.jdbc.DataSourceBuilder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.data.jpa.repository.config.EnableJpaRepositories
import javax.sql.DataSource


@Configuration
@EnableJpaRepositories(basePackages = ["com.vf.business.business.dao.repo"])
class DbConfig {

    @Bean
    fun getDataSource(): DataSource? {
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
        return dataSourceBuilder.build()
    }

}