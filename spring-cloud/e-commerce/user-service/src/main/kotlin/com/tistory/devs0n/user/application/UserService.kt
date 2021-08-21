package com.tistory.devs0n.user.application

import com.tistory.devs0n.user.client.OrderResponse
import com.tistory.devs0n.user.client.OrderServiceClient
import com.tistory.devs0n.user.domain.PasswordEncryptor
import com.tistory.devs0n.user.domain.SecurityUserDetails
import com.tistory.devs0n.user.domain.User
import com.tistory.devs0n.user.domain.UserRepository
import org.slf4j.LoggerFactory
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserService(
    private val passwordEncryptor: PasswordEncryptor,
    private val userRepository: UserRepository,
    private val orderServiceClient: OrderServiceClient,
    private val circuitBreakerFactory: CircuitBreakerFactory<*, *>
) : UserDetailsService {
    @Transactional(readOnly = true)
    fun getUser(userId: String): Pair<User, List<OrderResponse>> {
        val user = this.userRepository.findByUserId(userId) ?: throw RuntimeException("User Not Found")
//        val userOrder = this.orderServiceClient.getOrders(user.userId)
        val circuitBreaker = this.circuitBreakerFactory.create("circuitbreaker")

        LOGGER.info("Before call Order Service")
        val userOrder = circuitBreaker.run(
            { orderServiceClient.getOrders(user.userId) },
            {
                it.printStackTrace()
                emptyList()
            }
        )
        LOGGER.info("After call Order Service")
        return Pair(user, userOrder)
    }

    @Transactional
    fun createUser(email: String, password: String, name: String): User {
        val encryptedPassword = this.passwordEncryptor.encrypt(password)
        val user = User(email, name, encryptedPassword)
        return this.userRepository.save(user)
    }


    @Transactional(readOnly = true)
    fun getUserByEmail(email: String): User {
        val user = this.userRepository.findByEmail(email) ?: throw RuntimeException("User Not Found")
        val userOrder = this.orderServiceClient.getOrders(user.userId)
        return user
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

    companion object {
        private val LOGGER = LoggerFactory.getLogger(this::class.java)
    }
}
