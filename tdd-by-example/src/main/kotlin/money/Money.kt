package money

class Dollar(var amount: Int) {
    fun times(n: Int): Dollar {
        return Dollar(this.amount * n)
    }
}