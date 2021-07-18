package com.tistory.devs0n.user.config

import com.tistory.devs0n.user.application.TokenService
import com.tistory.devs0n.user.application.UserService
import com.tistory.devs0n.user.domain.SecurityPasswordEncoder
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
@EnableWebSecurity
class WebSecurityConfig(
    private val userService: UserService,
    private val passwordEncoder: SecurityPasswordEncoder,
    private val tokenService: TokenService,
) : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http
            .csrf().disable()
            .authorizeRequests().antMatchers("/**")
            .permitAll()
//            .hasIpAddress("*") // API GW IP
            .and()
            .addFilter(this.getAuthenticationFilter())
    }

    private fun getAuthenticationFilter(): AuthenticationFilter {
        val authenticationFilter = AuthenticationFilter(this.userService, this.tokenService)
        authenticationFilter.setAuthenticationManager(this.authenticationManager())
        return authenticationFilter
    }

    override fun configure(auth: AuthenticationManagerBuilder) {
        auth
            .userDetailsService(this.userService)
            .passwordEncoder(this.passwordEncoder)
    }
}
