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
        val dataSourceBuilder = DataSourceBuilder.create()
        dataSourceBuilder.driverClassName("org.postgresql.Driver")
        dataSourceBuilder.url("jdbc:" + System.getenv("DATABASE_URL"))
        return dataSourceBuilder.build()
    }

}