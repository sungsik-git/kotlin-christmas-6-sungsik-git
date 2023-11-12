package evnet

class SpecialEvent(day: String) {
    companion object {
        var specialDay = listOf("SUNDAY", "CHRISTMAS")
    }

    var onTarget = false

    init {
        if (specialDay.contains(day)) onTarget = true
    }

    fun applySpecialEvent(): Int {
        var discount = 0
        if (onTarget) {
            discount = 1000
        }
        return discount
    }
}