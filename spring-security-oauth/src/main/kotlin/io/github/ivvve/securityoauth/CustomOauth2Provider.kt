package io.github.ivvve.securityoauth

import org.springframework.security.oauth2.client.registration.ClientRegistration
import org.springframework.security.oauth2.core.AuthorizationGrantType
import org.springframework.security.oauth2.core.ClientAuthenticationMethod

enum class CustomOauth2Provider {

    Kakao {
        override fun getBuilder(registrationId: String): ClientRegistration.Builder {
            val builder = getBuilder(registrationId, ClientAuthenticationMethod.POST,
                CustomOauth2Provider.DEFAULT_REDIRECT_URL)
            builder.scope("account_email")
            builder.authorizationUri("https://kauth.kakao.com/oauth/authorize")
            builder.tokenUri("https://kauth.kakao.com/oauth/token")
            builder.userInfoUri("https://kapi.kakao.com/v2/user/me")
            builder.userNameAttributeName("id")
            builder.clientName("Kakao")
            return builder;
        }
    };

    companion object {
        private const val DEFAULT_REDIRECT_URL = "{baseUrl}/{action}/oauth2/code/{registrationId}"
    }


    protected fun getBuilder(
        registrationId: String, method: ClientAuthenticationMethod?,
        redirectUri: String
    ): ClientRegistration.Builder {
        val builder = ClientRegistration.withRegistrationId(registrationId)
        builder.clientAuthenticationMethod(method)
        builder.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
        builder.redirectUri(redirectUri)
        return builder
    }

    /**
     * Create a new
     * [ ClientRegistration.Builder][org.springframework.security.oauth2.client.registration.ClientRegistration.Builder] pre-configured with provider defaults.
     * @param registrationId the registration-id used with the new builder
     * @return a builder instance
     */
    abstract fun getBuilder(registrationId: String): ClientRegistration.Builder
}