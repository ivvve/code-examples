package io.github.ivvve.CompositePattern.`03`

class Monitor {
    val screen: MutableList<Monitor> = mutableListOf()
    val name = "모니터"

}

class Monitor32 {
    val name = "32인치"
}