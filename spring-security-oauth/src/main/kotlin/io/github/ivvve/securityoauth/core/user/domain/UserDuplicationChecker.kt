package io.github.ivvve.securityoauth.core.user.domain

class UserDuplicationChecker(
    private val userRepository: UserRepository
) {
    fun check(email: String) {
        val user = this.userRepository.findByEmail(email)

        if (user != null) {
            throw RuntimeException("User already exists")
        }
    }
}