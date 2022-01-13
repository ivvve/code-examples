package io.github.ivvve.securityoauth.core.user.application

import io.github.ivvve.securityoauth.core.user.domain.User
import io.github.ivvve.securityoauth.core.user.domain.authentication.UserAuthentication
import io.github.ivvve.securityoauth.core.user.domain.UserInformation
import io.github.ivvve.securityoauth.core.user.domain.UserRepository
import java.util.*

class UserSignUpService(
    private val userRepository: UserRepository
) {

    fun signUp(userInformation: UserInformation, authentication: UserAuthentication): User {
        val user = User(
            UUID.randomUUID().toString(),
            userInformation,
            mutableSetOf(authentication)
        )

        this.userRepository.save(user)
        return user
    }
}