package com.tistory.devs0n.bridge.program.program

import com.tistory.devs0n.bridge.program.os.OSFeature

// Refined Abstraction
class MemoProgram(feature: OSFeature) : Program(feature) {
    override fun start() {
        this.loadData()
        println("Start Memojang")
    }

    override fun shutdown() {
        println("Shutdown Memojang")
    }

    fun loadData() {
        super.readFile()
        println("Load Memo Data")
    }

    fun addMemo(memo: String) {
        // add memo
        super.writeFile()
    }

    fun deleteMemo(memo: String) {
        // delete memo
        super.writeFile()
    }
}
