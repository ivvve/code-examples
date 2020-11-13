package io.github.ivvve.BuilderPattern

class Computer {
    private var cpu: CPU? = null
    private var ram: MutableList<Memory> = mutableListOf()
    private var storage: MutableList<Storage> = mutableListOf()

    fun setCPU(cpu: CPU) {
        this.cpu = cpu
    }

    fun setRam(ram: List<Memory>) {
        this.ram.addAll(ram)
    }

    fun setStorage(storage: List<Storage>) {
        this.storage.addAll(storage)
    }

    override fun toString(): String {
        return """
            이 컴퓨터의 사양은 
            CPU=${this.cpu!!.getModel()},
            RAM=${this.ram.sumBy { it.getSize() }}GB,
            Storage=${this.storage.sumBy { it.getSize() }}GB
            입니다.
        """.trimIndent().replace("\n", "")
    }
}

class CPU(
    private val model: String
) {

    fun getModel(): String {
        return this.model
    }
}

class Memory(
    private val size: Int
) {

    fun getSize(): Int {
        return this.size
    }
}

class Storage(
    private val size: Int
) {

    fun getSize(): Int {
        return this.size
    }
}