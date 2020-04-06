package com.vf.business.config.auth

import com.vf.business.business.service.impl.auth.JwtTokenProvider
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.config.annotation.web.builders.HttpSecurity
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
        http
            .httpBasic().disable()
            .csrf().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .authorizeRequests()

                .antMatchers("/swagger-ui.html**").permitAll()
                .antMatchers("/webjars**").permitAll()

                .antMatchers(HttpMethod.POST, "/v1/auth/signin").permitAll() // login
                .antMatchers(HttpMethod.GET,"/v1/auth/me").authenticated() // get current user

                .antMatchers(HttpMethod.POST, "/v1/disciplines")
                    .hasAnyRole(AuthRoles.ADMIN.toString(), AuthRoles.PROFESSOR.toString()) // create disciplines
                .antMatchers(HttpMethod.PUT, "/v1/disciplines/*")
                    .hasAnyRole(AuthRoles.ADMIN.toString(), AuthRoles.PROFESSOR.toString()) // update disciplines


                .anyRequest().permitAll()
            .and().csrf().disable()
            .apply(JWTConfigurer(jwtTokenProvider))
        //@formatter:on
    }

}