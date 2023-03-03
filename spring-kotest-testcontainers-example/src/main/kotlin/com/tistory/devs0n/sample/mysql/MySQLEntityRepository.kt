package com.tistory.devs0n.sample.mysql

import org.springframework.data.jpa.repository.JpaRepository

interface MySQLEntityRepository : JpaRepository<MySQLEntity, Long>
