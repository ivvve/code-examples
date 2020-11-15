package io.github.ivvve.domain.user.usecase

import io.github.ivvve.domain.user.domain.User
import io.github.ivvve.domain.user.domain.UserID
import io.github.ivvve.domain.user.domain.UserRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserInfoService(
        private val userRepository: UserRepository
) {

    @Transactional
    fun registerUser(loginId: String, password: String, email: String, displayName: String): User {
        val user = User(loginId, password, email, displayName)
        return this.userRepository.save(user)
    }

    @Transactional
    fun changeUserInfo(userId: String, newEmail: String, newDisplayName: String): User {
        val user = this.getUser(userId)
        user.changeInfo(newEmail, newDisplayName)
        return this.userRepository.save(user)
    }

    @Transactional(readOnly = true)
    fun getUser(rawUserId: String): User {
        val userId = UserID.of(rawUserId)
        return this.userRepository.findById(userId)
                ?: throw RuntimeException("User with the ID(${rawUserId}) not found")
    }
}