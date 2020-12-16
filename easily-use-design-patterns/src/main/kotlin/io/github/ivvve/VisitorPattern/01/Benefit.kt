package io.github.ivvve.VisitorPattern.`01`

interface Benefit {
    fun point(member: Member): Int
    fun discount(member: Member): Int
}

class BenefitImpl : Benefit {
    override fun point(member: Member): Int {
        if (member is GoldMember) {
            return 100
        } else if (member is SilverMember) {
            return 50
        }

        throw IllegalArgumentException("Not supported member")
    }

    override fun discount(member: Member): Int {
        if (member is GoldMember) {
            return 20
        } else if (member is SilverMember) {
            return 10
        }

        throw IllegalArgumentException("Not supported member")
    }
}