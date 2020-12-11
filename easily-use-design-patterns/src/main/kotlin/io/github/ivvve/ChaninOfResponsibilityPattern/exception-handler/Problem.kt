package io.github.ivvve.ChaninOfResponsibilityPattern.`exception-handler`

class Problem(val number: Int) {
    override fun toString(): String {
        return "Problem-${this.number}"
    }
}