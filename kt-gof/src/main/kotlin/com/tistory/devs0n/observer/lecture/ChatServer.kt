package com.tistory.devs0n.observer.lecture

class ChatServer {
    private val subscribers: MutableMap<String, MutableList<Subscriber>> = mutableMapOf()

    fun register(topic: String, subscriber: Subscriber) {
        if (!this.subscribers.containsKey(topic)) {
            this.subscribers[topic] = mutableListOf()
        }

        this.subscribers[topic]!!.add(subscriber)
    }

    fun unregister(topic: String, subscriber: Subscriber) {
        if (this.subscribers.containsKey(topic)) {
            this.subscribers[topic]!!.remove(subscriber)
        }
    }

    fun sendMessage(from: Subscriber, topic : String, message: String) {
        if (this.subscribers.containsKey(topic)) {
            val subscribers = this.subscribers[topic]!!
            subscribers.forEach {
                it.onMessage("[${from}] $message")
            }
        }
    }
}
