package io.github.ivvve.BuilderPattern

abstract class Builder(
    protected var algorithm: Algorithm
) {
    @JvmName("setAlgorithm1")
    fun setAlgorithm(algorithm: Algorithm) {
        this.algorithm = algorithm
    }

    fun getInstance(): Computer {
        return this.algorithm.getInstance()
    }

    abstract fun build(): Builder
}

abstract class Algorithm() {
    protected val composite = Computer()

    abstract fun setCpu(model: String)
    abstract fun setRam(size: List<Int>)
    abstract fun setStorage(size: List<Int>)

    fun getInstance(): Computer {
        return this.composite
    }
}