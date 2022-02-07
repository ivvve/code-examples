package com.tistory.devs0n.strategy.runner.client

import com.tistory.devs0n.strategy.runner.context.Runner
import com.tistory.devs0n.strategy.runner.strategy.Fast
import com.tistory.devs0n.strategy.runner.strategy.Slow

fun main() {
    val runner = Runner()
    runner.run()

    println("==FAST==")
    runner.changeSpeed(Fast())
    runner.run()

    println("==SLOW==")
    runner.changeSpeed(Slow())
    runner.run()

    println("==Custom==")
    runner.changeSpeed({ println("???") })
    runner.run()
}
