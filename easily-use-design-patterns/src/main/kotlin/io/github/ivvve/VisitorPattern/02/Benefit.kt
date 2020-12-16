package io.github.ivvve.VisitorPattern.`02`

interface Benefit {
    fun getBenefit(member: GoldMember): Int
    fun getBenefit(member: SilverMember): Int
}

class PointBenefit : Benefit {
    override fun getBenefit(member: GoldMember): Int = 100
    override fun getBenefit(member: SilverMember): Int = 50
}

class DiscountBenefit : Benefit {
    override fun getBenefit(member: GoldMember): Int = 10
    override fun getBenefit(member: SilverMember): Int = 5
}
