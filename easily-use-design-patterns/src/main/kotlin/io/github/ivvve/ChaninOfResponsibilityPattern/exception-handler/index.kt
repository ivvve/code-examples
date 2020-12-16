package io.github.ivvve.ChaninOfResponsibilityPattern.`exception-handler`

fun main() {
    val noSupporter: Supporter = NoSupporter("No")
    val limit100Supporter: Supporter = LimitSupporter("Limit 100", 100)
    val specialSupporter: Supporter = SpecialSupporter("Special", 429)
    val limit200Supporter: Supporter = LimitSupporter("Limit 200", 200)
    val oddSupporter: Supporter = OddSupporter("Odd")
    val limit300Supporter: Supporter = LimitSupporter("Limit 300", 300)

    noSupporter.setNext(limit100Supporter)
        .setNext(specialSupporter)
        .setNext(limit200Supporter)
        .setNext(oddSupporter)
        .setNext(limit300Supporter)

    for (i in 0..500 step 33) {
        noSupporter.support(Problem(i))
    }

    /**
     * [Limit 100] resolved [Problem-0]
     * [Limit 100] resolved [Problem-33]
     * [Limit 100] resolved [Problem-66]
     * [Limit 100] resolved [Problem-99]
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
