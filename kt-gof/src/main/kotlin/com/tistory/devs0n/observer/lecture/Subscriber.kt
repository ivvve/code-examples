package com.tistory.devs0n.observer.lecture

interface Subscriber {
    fun onMessage(message: String)
}
