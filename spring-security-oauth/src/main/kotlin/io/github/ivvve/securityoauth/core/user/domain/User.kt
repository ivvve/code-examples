package io.github.ivvve.securityoauth.core.user.domain

import io.github.ivvve.securityoauth.core.user.domain.authentication.UserAuthentication

data class User(
    private val id: String,
    private val information: UserInformation,
    private val authentications: MutableSet<UserAuthentication>
)