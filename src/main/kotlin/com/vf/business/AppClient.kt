package com.vf.business

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@SpringBootApplication
@ComponentScan
@EnableJpaRepositories(basePackages = ["com.vf.business.business.dao.repo"])
class Application

fun main(args: Array<String>) {
    SpringApplication.run(Application::class.java, *args)
}