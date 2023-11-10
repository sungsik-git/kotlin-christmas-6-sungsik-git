package evnet

import transformation.VisitDayOfWeek

class ApplyEvent (private val visitDay: Int, private val orderMenus: List<String>){
    fun test(){
        var testPrice1 = DdayEvent(visitDay).applyDdayEvent()

        val dayOfWeeks = VisitDayOfWeek(visitDay).transformDayOfWeek()
        println(dayOfWeeks)
        var testPrice2 = WeekdayEvent(dayOfWeeks, orderMenus).applyWeekdayEvent()
        println(testPrice1)
        println(testPrice2)
    }
}