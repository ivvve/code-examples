package io.github.ivvve.ObserverPattern

import io.reactivex.subjects.PublishSubject
import kotlin.random.Random

fun main() {
    val intSubject = PublishSubject.create<Int>()

    // subscribing
    intSubject.subscribe{
        println("Subscribed int value: $it")
    }

    for (i in 1..10) {
        // publishing
        intSubject.onNext(Random.nextInt(500))
        Thread.sleep(200)
    }
}
