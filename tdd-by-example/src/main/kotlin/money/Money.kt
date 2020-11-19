package money

open class Money(protected val amount: Int, protected val currency: String) {
    companion object {
        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Franc(amount, "CHF")
        }
    }

    open fun times(multiplier: Int): Money {
        return Money(this.amount * multiplier, currency)
    }

    fun currency(): String {
        return this.currency
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true

        other as Money

        if (amount != other.amount) return false
        if (currency != other.currency) return false

        return true
    }

    override fun hashCode(): Int {
        var result = amount
        result = 31 * result + currency.hashCode()
        return result
    }
}

class Franc(amount: Int, currency: String): Money(amount, currency) {
}
