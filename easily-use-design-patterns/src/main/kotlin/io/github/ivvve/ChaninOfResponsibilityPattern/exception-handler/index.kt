package io.github.ivvve.ChaninOfResponsibilityPattern.`exception-handler`

fun main() {
    val noSupport: Support = NoSupport("No")
    val limit100Support: Support = LimitSupport("Limit", 100)
    val specialSupport: Support = SpecialSupport("Special", 429)
    val limit200Support: Support = LimitSupport("Limit 200", 200)
    val oddSupport: Support = OddSupport("Odd")
    val limit300Support: Support = LimitSupport("Limit 300", 300)

    noSupport.setNext(limit100Support)
        .setNext(specialSupport)
        .setNext(limit200Support)
        .setNext(oddSupport)
        .setNext(limit300Support)

    for (i in 0..500 step 33) {
        noSupport.support(Problem(i))
    }

    /**
     * [Limit] resolved [Problem-0]
     * [Limit] resolved [Problem-33]
     * [Limit] resolved [Problem-66]
     * [Limit] resolved [Problem-99]
     * [Limit 200] resolved [Problem-132]
     * [Limit 200] resolved [Problem-165]
     * [Limit 200] resolved [Problem-198]
     * [Odd] resolved [Problem-231]
     * [Limit 300] resolved [Problem-264]
     * [Odd] resolved [Problem-297]
     * Failed to resolve Problem-330
     * [Odd] resolved [Problem-363]
     * Failed to resolve Problem-396
     * [Special] resolved [Problem-429]
     * Failed to resolve Problem-462
     * [Odd] resolved [Problem-495]
     */
}
