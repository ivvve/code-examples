package io.github.ivvve.ChaninOfResponsibilityPattern

class Problem(val number: Int) {
    override fun toString(): String {
        return "Problem-${this.number}"
    }
}