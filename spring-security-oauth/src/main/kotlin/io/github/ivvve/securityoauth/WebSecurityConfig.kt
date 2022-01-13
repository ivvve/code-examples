package io.github.ivvve.securityoauth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider
import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter

@Configuration
@EnableWebSecurity(debug = true)
class WebSecurityConfig(
    private val customOauth2UserService: CustomOauth2UserService
) : WebSecurityConfigurerAdapter() {


    override fun configure(http: HttpSecurity) {
        http
            .httpBasic().disable()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .csrf().disable()
            .authorizeRequests()
            .anyRequest().authenticated()
            .and()
            .addFilterBefore(MyFilter(), BasicAuthenticationFilter::class.java)
            .oauth2Login()
                .userInfoEndpoint()
                .userService(customOauth2UserService)
//                .oidcUserService()
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
            .clientId("d661add333a7017b13a1")
            .clientSecret("e4fd37a59cab5669f7cc029ed4e8dcfb803b06b7")
            .build()
    }

    private fun kakaoClientRegistration(): ClientRegistration {
        return CustomOauth2Provider.Kakao.getBuilder("kakao")
            .clientId("ea66de69c47b7d0bec50468debfc03fc")
            .clientSecret("IkFEHufhX63sAtv8xA3tWzUW3J8ZqWdh")
            .build()
    }
}
