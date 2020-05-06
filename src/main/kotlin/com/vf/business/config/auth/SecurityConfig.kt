package com.vf.business.config.auth

import com.vf.business.business.service.impl.auth.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy


@Configuration
class SecurityConfig(
        private val jwtTokenProvider: JwtTokenProvider
): WebSecurityConfigurerAdapter() {

    @Bean
    @Throws(Exception::class)
    override fun authenticationManagerBean(): AuthenticationManager? {
        return super.authenticationManagerBean()
    }

    @Throws(Exception::class)
    override fun configure(http: HttpSecurity) {
        //@formatter:off
        http.authorizeRequests()
                .antMatchers("/api/*/auth/signin").permitAll()
                .antMatchers("/api/*/auth/password-recovery").permitAll()
                .antMatchers("/api/*/auth/password-reset").permitAll()
                .antMatchers("/api/*/registrations/professor").permitAll()
                .anyRequest().authenticated()
                .and()
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and().csrf().disable()
                
            .apply(JWTConfigurer(jwtTokenProvider))
        //@formatter:on
    }

}