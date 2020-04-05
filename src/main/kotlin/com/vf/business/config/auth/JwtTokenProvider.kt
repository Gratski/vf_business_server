package com.vf.business.config.auth

import com.vf.business.business.dao.models.Professor
import com.vf.business.business.dao.models.Student
import com.vf.business.business.service.itf.UsersService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.JwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.security.authentication.BadCredentialsException
import org.springframework.security.authentication.CredentialsExpiredException
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import java.util.*
import javax.annotation.PostConstruct
import javax.servlet.http.HttpServletRequest


@Component
class JwtTokenProvider {

    private val AUTHORIZATION_HEADER = "Authorization"
    private val AUTHORIZATION_VALUE_PREFIX = "Bearer "

    @Value("\${security.jwt.token.secret-key}")
    var secretKey = "secret"

    @Value("\${security.jwt.token.expire-length}")
    var validityInMilliseconds: Long = 3600000 // 1h

    @Autowired
    lateinit var userService: UsersService

    @PostConstruct
    fun init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.toByteArray());
    }

    fun createToken(username: String?, roles: List<String?>?): String? {
        val claims: Claims = Jwts.claims().setSubject(username)
        claims["roles"] = roles

        val now = Date()
        val validity = Date(now.time + validityInMilliseconds)
        return Jwts.builder() //
                .setClaims(claims) //
                .setIssuedAt(now) //
                .setExpiration(validity) //
                .signWith(SignatureAlgorithm.HS256, secretKey) //
                .compact()
    }

    fun getAuthentication(token: String?): Authentication? {
        val userOpt = userService.getUser(extractUserIdFromToken(token))
        userOpt.orElseThrow{
            throw UsernameNotFoundException("The token username was not found")
        }

        val user = userOpt.get()
        val authorities = mutableListOf<GrantedAuthority>()
        authorities.add(SimpleGrantedAuthority("USER"))
        if ( user is Student ) {
            authorities.add(SimpleGrantedAuthority("STUDENT"))
        } else if ( user is Professor ) {
            authorities.add(SimpleGrantedAuthority("PROFESSOR"))
        }

        return UsernamePasswordAuthenticationToken(user, "", authorities)
    }

    fun extractUserIdFromToken(token: String?): Int =
        Integer.parseInt(Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).body.subject)


    fun resolveToken(req: HttpServletRequest): String? {
        val bearerToken = req.getHeader(AUTHORIZATION_HEADER)
        if (bearerToken != null && bearerToken.startsWith(AUTHORIZATION_VALUE_PREFIX)) {
            return bearerToken.substring(7, AUTHORIZATION_HEADER.length)
        }
        return null
    }

    fun validateToken(token: String?): Boolean {
        return try {
            val claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
            if (claims.body.expiration.before(Date())) {
                false
            }
            true
        } catch (e: JwtException) {
            throw CredentialsExpiredException("Credentials Expired")
        } catch (e: IllegalArgumentException) {
            throw BadCredentialsException("Something went wrong during authtication process")
        }
    }


}