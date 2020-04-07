package com.vf.business.config.auth

import com.vf.business.business.service.impl.auth.JwtTokenProvider
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.filter.GenericFilterBean
import javax.servlet.FilterChain
import javax.servlet.ServletRequest
import javax.servlet.ServletResponse
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class JWTFilter( private val jwtTokenProvider: JwtTokenProvider) : GenericFilterBean() {

    override fun doFilter(
            req: ServletRequest?, rsp: ServletResponse?,
            chain: FilterChain?) {

        try {
            val token = jwtTokenProvider.resolveToken(req as HttpServletRequest);
            if (token != null && jwtTokenProvider.validateToken(token)) {
                val auth: Authentication? = jwtTokenProvider.getAuthentication(token)
                SecurityContextHolder.getContext().authentication = auth
            }
            chain?.doFilter(req, rsp)
        } catch (e: RuntimeException) {
            (rsp as HttpServletResponse).status = 401
        }

    }

}
