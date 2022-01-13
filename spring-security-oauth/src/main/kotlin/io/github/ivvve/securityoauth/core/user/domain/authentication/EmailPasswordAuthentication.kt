package io.github.ivvve.securityoauth.core.user.domain.authentication

class EmailPasswordAuthentication(
    method: AuthenticationMethod,
    val email: String,
    val password: String
) : UserAuthentication(method)