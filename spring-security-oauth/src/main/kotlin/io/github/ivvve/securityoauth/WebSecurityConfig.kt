package io.github.ivvve.securityoauth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository

@Configuration
class WebSecurityConfig : WebSecurityConfigurerAdapter() {

    override fun configure(http: HttpSecurity) {
        http.authorizeRequests().anyRequest().authenticated().and().oauth2Login()
    }

    @Bean
    fun clientRegistrationRepository(): ClientRegistrationRepository {
        return InMemoryClientRegistrationRepository(listOf(
            this.githubClientRegistration(),
            this.kakaoClientRegistration()
        ))
    }

    private fun githubClientRegistration(): ClientRegistration {
        return CommonOAuth2Provider.GITHUB.getBuilder("github")
            .clientId("")
            .clientSecret("")
            .build()
    }

    private fun kakaoClientRegistration(): ClientRegistration {
        return CustomOauth2Provider.Kakao.getBuilder("kakao")
            .clientId("")
            .clientSecret("")
            .build()
    }
}
