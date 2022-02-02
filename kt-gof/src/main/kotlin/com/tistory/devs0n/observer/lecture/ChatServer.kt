package com.tistory.devs0n.observer.lecture

class ChatServer {
    private val subscribers: MutableMap<String, MutableList<Subscriber>> = mutableMapOf()

    fun register(subject: String, subscriber: Subscriber) {
        if (!this.subscribers.containsKey(subject)) {
            this.subscribers[subject] = mutableListOf()
        }

        this.subscribers[subject]!!.add(subscriber)
    }

    fun unregister(subject: String, subscriber: Subscriber) {
        if (this.subscribers.containsKey(subject)) {
            this.subscribers[subject]!!.remove(subscriber)
        }
    }

    fun sendMessage(from: Subscriber, subject : String, message: String) {
        if (this.subscribers.containsKey(subject)) {
            val subscribers = this.subscribers[subject]!!
            subscribers.forEach {
                it.onMessage("[${from}] $message")
            }
        }
    }
}
