package io.github.ivvve.VisitorPattern.`02`

interface Member {
    fun getBenefit(benefit: Benefit): Int
}

class GoldMember : Member {
    override fun getBenefit(benefit: Benefit): Int {
        return benefit.getBenefit(this)
    }
}

class SilverMember : Member {
    override fun getBenefit(benefit: Benefit): Int {
        return benefit.getBenefit(this)
    }
}
