package money

class Dollar(var amount: Int) {
    fun times(multiplier: Int): Dollar {
        return Dollar(this.amount * multiplier)
    }
}
