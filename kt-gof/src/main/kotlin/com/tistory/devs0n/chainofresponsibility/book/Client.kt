package com.tistory.devs0n.chainofresponsibility.book

import com.tistory.devs0n.chainofresponsibility.book.support.LimitSupport
import com.tistory.devs0n.chainofresponsibility.book.support.NoSupport
import com.tistory.devs0n.chainofresponsibility.book.support.SpecialSupport
import com.tistory.devs0n.chainofresponsibility.book.support.Support

fun main() {
    val alice: Support = NoSupport("Alice")
    val bob: Support = LimitSupport("Bob", 100)
    val charlie: Support = SpecialSupport("Charlie", 429)
    val diana: Support = LimitSupport("Diana", 200)
    val fred: Support = LimitSupport("Fred", 300)

    alice.setNext(bob)
        .setNext(charlie)
        .setNext(diana)
        .setNext(fred)

    (1..500).forEach { alice.support(Trouble(it)) }
}
