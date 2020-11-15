package money

class Dollar(private val amount: Int) {
    fun times(n: Int): Dollar {
        return Dollar(this.amount * n)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Dollar

        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        return amount
    }

}