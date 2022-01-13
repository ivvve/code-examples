package com.tistory.devs0n.flywayexample.user

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
