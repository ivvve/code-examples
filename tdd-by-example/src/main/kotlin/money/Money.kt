package money

open class Money(protected val amount: Int) {
    companion object {
        fun dollar(amount: Int): Money {
            return Dollar(amount)
        }
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        return amount
    }
}

class Dollar(amount: Int): Money(amount) {
    fun times(multiplier: Int): Money {
        return Dollar(this.amount * multiplier)
    }
}

class Franc(amount: Int): Money(amount) {
    fun times(multiplier: Int): Money {
        return Franc(this.amount * multiplier)
    }
}
