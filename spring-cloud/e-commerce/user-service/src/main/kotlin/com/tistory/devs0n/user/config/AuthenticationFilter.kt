package com.tistory.devs0n.user.config

import com.fasterxml.jackson.databind.ObjectMapper
import com.tistory.devs0n.user.application.TokenService
import com.tistory.devs0n.user.application.UserService
import com.tistory.devs0n.user.domain.SecurityUserDetails
import com.tistory.devs0n.user.ui.dto.LoginRequest
import org.slf4j.LoggerFactory
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.AuthenticationException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

class AuthenticationFilter(
    private val userService: UserService,
    private val tokenService: TokenService,
): UsernamePasswordAuthenticationFilter() {
    private val objectMapper = ObjectMapper()

    override fun attemptAuthentication(request: HttpServletRequest, response: HttpServletResponse): Authentication {
        val loginRequest = this.toLoginRequest(request)
        val authenticationToken = UsernamePasswordAuthenticationToken(
            loginRequest.email, // principle: username
            loginRequest.password, // credential: password
            emptyList() // no authorities
        )

        return try {
            this.authenticationManager.authenticate(authenticationToken)
        } catch (exception: AuthenticationException) {
            LOGGER.error("Fail authentication", exception)
            throw exception
        }
    }

    private fun toLoginRequest(request: HttpServletRequest): LoginRequest {
        return objectMapper.readValue(request.inputStream, LoginRequest::class.java)
    }

    override fun successfulAuthentication(
        request: HttpServletRequest,
        response: HttpServletResponse,
        chain: FilterChain,
        authResult: Authentication
    ) {
        val userDetails = authResult.principal as SecurityUserDetails
        val user = this.userService.getUserByEmail(userDetails.username)
        val token = this.tokenService.createToken(user.userId)

        response.status = HttpServletResponse.SC_OK
        response.contentType = "application/json"
        response.writer.write("""{ "token" : "$token" """)
        response.writer.flush()
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}