package io.github.ivvve.security.config

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder

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

    override fun configure(auth: AuthenticationManagerBuilder?) {
        // in-memory authentication 설정 시 spring.security.user 설정은 무시 된다
        auth!!.inMemoryAuthentication()
            .withUser("admin").password("1234").authorities("ROLE_ADMIN")
                .and()
            .withUser("user").password("1234").authorities("ROLE_USER")
                .and()
            .passwordEncoder(NoOpPasswordEncoder.getInstance()) // no encryption
    }
}