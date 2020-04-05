package com.vf.business.config.auth

import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest

class JWTFilter( private val jwtTokenProvider: JwtTokenProvider ) : GenericFilterBean() {

    override fun doFilter(
            req: ServletRequest?, rsp: ServletResponse?,
            chain: FilterChain?) {

        val token = jwtTokenProvider.resolveToken(req as HttpServletRequest);

        if (token != null && jwtTokenProvider.validateToken(token)) {
            val auth: Authentication? = jwtTokenProvider.getAuthentication(token)
            SecurityContextHolder.getContext().authentication = auth
        }
        chain?.doFilter(req, rsp);
    }

}
