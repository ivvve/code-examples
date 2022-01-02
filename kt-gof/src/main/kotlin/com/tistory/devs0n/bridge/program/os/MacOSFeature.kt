package com.tistory.devs0n.bridge.program.os

// Concrete Implementation
class MacOSFeature : OSFeature {
    override fun readFile() {
        println("[MacOS System] read file...")
    }

    override fun writeFile() {
        println("[MacOS System] write file...")
    }
}
