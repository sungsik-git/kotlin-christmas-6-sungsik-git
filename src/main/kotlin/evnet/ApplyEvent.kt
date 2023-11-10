package evnet

import transformation.VisitDayOfWeek

class ApplyEvent (private val day: Int, private val menus: List<String>){
    fun test(){
        var testPrice1 = DdayEvent(day).applyDdayEvent()

        val dayOfWeeks = VisitDayOfWeek(day).transformDayOfWeek()
        println(dayOfWeeks)
        var testPrice2 = WeekdayEvent(dayOfWeeks, menus).applyWeekdayEvent()
        println(testPrice1)
        println(testPrice2)
    }
}