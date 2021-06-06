package com.tistory.devs0n.springjpaquerydsl.domain

import org.springframework.data.jpa.repository.JpaRepository

interface ProductRepository : JpaRepository<Product, Long>
