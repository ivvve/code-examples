package money

class Dollar(var amount: Int) {
    fun times(n: Int) {
        this.amount = amount * n
    }
}