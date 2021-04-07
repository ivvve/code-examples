package com.tistory.devs0n.mysqlencoding

import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>
