package com.tistory.devs0n.jpavo

import com.tistory.devs0n.jpavo.user.User
import com.tistory.devs0n.jpavo.user.UserEmail
import com.tistory.devs0n.jpavo.user.UserName
import com.tistory.devs0n.jpavo.user.UserRepository
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class JpaValueClassApplication

fun main(args: Array<String>) {
    val ac = runApplication<JpaValueClassApplication>(*args)

    val userRepository = ac.getBean(UserRepository::class.java)
    val user = userRepository.save(User(name = UserName("Chris"), email = UserEmail("chris@gmail.com")))
    println(user)
}
