package evnet

class DdayEvent(private val day: Int) {
    companion object {
        const val DEFAULT_DISCOUNT: Int = 1000
        const val DAILY_ADDITIONAL_DISCOUNT: Int = 100
    }

    private var onTarget = false
    private var discount = 0

    init {
        if (day >= 1 && day <= 25) onTarget = true
    }

    fun applyDdayEvent(): Int {
        if (onTarget) {
            discount += DEFAULT_DISCOUNT + ((day - 1) * DAILY_ADDITIONAL_DISCOUNT)
        }
        return discount
    }
}