package com.tistory.devs0n.lock.order

interface OrderRepository {
    fun findAllByIdIn(productNumbers: List<Long>)
}
