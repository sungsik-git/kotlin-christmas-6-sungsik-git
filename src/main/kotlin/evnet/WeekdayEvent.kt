package evnet

class WeekdayEvent (day: String, menus: List<String>){
    companion object{
        val weekDays = listOf("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY")
    }

    private var onTarget = false
    private var discount = 0

    init {
        if(weekDays.contains(day)){
            onTarget = true
        }

    }

    fun applyWeekdayEvent() : Int{
        if(onTarget) {
            discount += 2023
        }
        return discount
    }
}