package io.github.ivvve.securityoauth.core.user.domain.authentication

class KakaoUserAuthentication(
    method: AuthenticationMethod,
    kakaoId: Long
) : UserAuthentication(method) {
}