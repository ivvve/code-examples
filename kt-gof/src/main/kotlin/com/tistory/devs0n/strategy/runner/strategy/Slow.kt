package com.tistory.devs0n.strategy.runner.strategy

class Slow : Speed {
    override fun run() {
        println("Run slowly...")
    }
}
