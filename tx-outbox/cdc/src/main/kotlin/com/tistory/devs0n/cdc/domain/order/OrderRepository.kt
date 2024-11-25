package com.tistory.devs0n.cdc.domain.order

import org.springframework.data.repository.CrudRepository

interface OrderRepository : CrudRepository<Order, Long>
