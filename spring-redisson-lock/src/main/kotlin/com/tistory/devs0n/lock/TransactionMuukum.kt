package com.tistory.devs0n.lock

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class TransactionMuukum {
    @Transactional
    fun <A, B> process(fun1: () -> A, fun2: () -> B): Pair<A, B> = Pair(fun1.invoke(), fun2.invoke())

    @Transactional
    fun <A, B, C> process(fun1: () -> A, fun2: () -> B, fun3: () -> C): Triple<A, B, C> =
        Triple(fun1.invoke(), fun2.invoke(), fun3.invoke())

    fun process(
        transactionKey: String,
        function: () -> Unit
    ) {
        function.invoke()
    }
}
