package com.tistory.devs0n.bridge.program.program

import com.tistory.devs0n.bridge.program.os.OSFeature

// Refined Abstraction
class CalculatorProgram(feature: OSFeature) : Program(feature) {
    override fun start() {
        this.loadCalculationHistory()
        println("Start Calculator")
    }

    override fun shutdown() {
        println("Shutdown Calculator")
    }

    fun calculate(expression: String) {
        this.writeFile() // save calculation history
    }

    fun loadCalculationHistory() {
        this.readFile()
    }
}
