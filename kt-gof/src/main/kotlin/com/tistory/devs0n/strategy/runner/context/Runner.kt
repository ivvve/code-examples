package com.tistory.devs0n.strategy.runner.context

import com.tistory.devs0n.strategy.runner.strategy.Normal
import com.tistory.devs0n.strategy.runner.strategy.Speed

class Runner {
    private var speed: Speed = Normal()
    private var distance = 0

    fun run() {
        this.speed.run()
    }

    fun changeSpeed(speed: Speed) {
        this.speed = speed
    }
}
