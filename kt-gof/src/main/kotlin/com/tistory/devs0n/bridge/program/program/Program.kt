package com.tistory.devs0n.bridge.program.program

import com.tistory.devs0n.bridge.program.os.OSFeature

// Abstraction
abstract class Program(
    private val feature: OSFeature
) {
    abstract fun start()

    abstract fun shutdown()

    fun readFile() {
        this.feature.readFile()
    }

    fun writeFile() {
        this.feature.writeFile()
    }
}
