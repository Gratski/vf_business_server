package com.vf.business.config.i18n

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.support.ResourceBundleMessageSource
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver
import java.util.*
import javax.servlet.http.HttpServletRequest

@Configuration
class CustomLocaleResolver : AcceptHeaderLocaleResolver(), WebMvcConfigurer {
    private var LOCALES: List<Locale> = listOf(
            Locale("en"),
            Locale("pt"),
            Locale("es"),
            Locale("fr")
    )

    override fun resolveLocale(request: HttpServletRequest): Locale {
        val headerLang = request.getHeader("Accept-Language")
        return if (headerLang == null || headerLang.isEmpty()) Locale.getDefault() else Locale.lookup(Locale.LanguageRange.parse(headerLang), LOCALES)
    }

    @Bean
    fun messageSource(): ResourceBundleMessageSource {
        val rs = ResourceBundleMessageSource()
        rs.setBasename("messages")
        rs.setDefaultEncoding("UTF-8")
        rs.setUseCodeAsDefaultMessage(true)
        return rs
    }
}