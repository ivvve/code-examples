package io.github.ivvve.securityoauth

import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest
import org.springframework.security.oauth2.core.user.OAuth2User
import org.springframework.stereotype.Component

@Component
class CustomOauth2UserService : DefaultOAuth2UserService() {
    override fun loadUser(userRequest: OAuth2UserRequest): OAuth2User {
        val user = super.loadUser(userRequest)

        val context = SecurityContextHolder.getContext()

        // 기존에 있는지 확인
        val registrationId = userRequest.clientRegistration.registrationId

        if (registrationId == "github") {
            val nodeId = user.attributes["node_id"]!! as String

        } else if (registrationId == "kakao") {
            val id = user.attributes["id"]!! as Long

        }
        // TODO add user

        return user
    }
}