package io.github.ivvve.security.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http!!
            .authorizeRequests()
                .antMatchers("/account", "/balance", "/loans", "/cards").authenticated()
                .antMatchers("/notices", "/contact").permitAll()
                .and()
            .formLogin()
                .and()
            .httpBasic()
    }
}