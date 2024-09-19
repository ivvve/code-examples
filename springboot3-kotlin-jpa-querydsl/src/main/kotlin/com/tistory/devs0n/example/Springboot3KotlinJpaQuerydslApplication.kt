package com.tistory.devs0n.example

import com.querydsl.jpa.impl.JPAQueryFactory
import com.tistory.devs0n.example.entity.QProduct.product
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class Springboot3KotlinJpaQuerydslApplication

fun main(args: Array<String>) {
    val ac = runApplication<Springboot3KotlinJpaQuerydslApplication>(*args)
    val products = ac.getBean(JPAQueryFactory::class.java)
        .selectFrom(product)
        .fetch()
    products.forEach { println(it) }
}
