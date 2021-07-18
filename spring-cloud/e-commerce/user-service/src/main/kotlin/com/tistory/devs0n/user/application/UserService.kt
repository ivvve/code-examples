package com.tistory.devs0n.user.application

import com.tistory.devs0n.user.domain.SecurityUserDetails
import com.tistory.devs0n.user.domain.PasswordEncryptor
import com.tistory.devs0n.user.domain.User
import com.tistory.devs0n.user.domain.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val passwordEncryptor: PasswordEncryptor,
    private val userRepository: UserRepository,
) : UserDetailsService {
    @Transactional(readOnly = true)
    fun getUser(userId: String): User {
        return this.userRepository.findByUserId(userId) ?: throw RuntimeException("User Not Found")
    }

    @Transactional
    fun createUser(email: String, password: String, name: String): User {
        val encryptedPassword = this.passwordEncryptor.encrypt(password)
        val user = User(email, name, encryptedPassword)
        return this.userRepository.save(user)
    }


    @Transactional(readOnly = true)
    fun getUserByEmail(email: String): User {
        return this.userRepository.findByEmail(email) ?: throw RuntimeException("User Not Found")
    }

    /**
     * for Spring Security feature
     *
     * @param username is Email for User Service
     */
    @Transactional(readOnly = true)
    override fun loadUserByUsername(username: String): UserDetails {
        val user = this.getUserByEmail(username)
        return SecurityUserDetails(user.email, user.encryptedPassword)
    }
}
