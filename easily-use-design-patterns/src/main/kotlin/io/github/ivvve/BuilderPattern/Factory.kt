package io.github.ivvve.BuilderPattern

class Factory(algorithm: Algorithm) : Builder(algorithm) {

    override fun build(): Builder {
        super.algorithm.setCpu("i7")
        super.algorithm.setRam(listOf(8, 8))
        super.algorithm.setStorage(listOf(256, 512))
        return this
    }
}

class ProductModel : Algorithm() {
    override fun setCpu(model: String) {
        super.composite.setCPU(CPU(model))
    }

    override fun setRam(size: List<Int>) {
        super.composite.setRam(
            size.map { Memory(it) }
        )
    }

    override fun setStorage(size: List<Int>) {
        super.composite.setStorage(
            size.map { Storage(it) }
        )
    }
}