package com.tistory.devs0n.proxytx

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.transaction.support.TransactionSynchronizationManager

@SpringBootApplication
class ProxyBasedTransactionApplication

fun main(args: Array<String>) {
    val ac = runApplication<ProxyBasedTransactionApplication>(*args)
    val service = ac.getBean(TransactionService::class.java)

    println("============")
    service.outer()
    println("============")
    service.inner()
    println("============")

    /**
     * ============
     * 2022-03-06 13:22:48.379  INFO 16453 --- [           main] c.t.devs0n.proxytx.TransactionService    : Is in transaction false
     * ============
     * 2022-03-06 13:22:48.417 TRACE 16453 --- [           main] o.s.t.i.TransactionInterceptor           : Getting transaction for [com.tistory.devs0n.proxytx.TransactionService.inner]
     * 2022-03-06 13:22:48.417  INFO 16453 --- [           main] c.t.devs0n.proxytx.TransactionService    : Is in transaction true
     * 2022-03-06 13:22:48.417 TRACE 16453 --- [           main] o.s.t.i.TransactionInterceptor           : Completing transaction for [com.tistory.devs0n.proxytx.TransactionService.inner]
     * ============
     */
}

@Service
class TransactionService {

    fun outer(): Unit {
        this.inner()
    }

    @Transactional
    fun inner(): Unit {
        LOGGER.info(
            "Is in transaction {}",
            TransactionSynchronizationManager.isActualTransactionActive()
        )
    }

    companion object {
        private val LOGGER = LoggerFactory.getLogger(TransactionService::class.java)
    }
}
