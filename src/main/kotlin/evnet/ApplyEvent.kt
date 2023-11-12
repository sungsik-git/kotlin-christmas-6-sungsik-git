package evnet

import transformation.VisitDayOfWeek

class ApplyEvent (private val visitDay: Int, private val orderMenus: List<String>){
    fun test(){
        var dDayEvent = DdayEvent(visitDay).applyDdayEvent()

        val dayOfWeeks = VisitDayOfWeek(visitDay).transformDayOfWeek()
        var weekdayEvent = WeekdayEvent(dayOfWeeks, orderMenus).applyWeekdayEvent()
        var weekendEvent = WeekendEvent(dayOfWeeks, orderMenus).applyWeekendEvent()



        println("visitDayOfWeek : $dayOfWeeks")
        println("dDayEvent : $dDayEvent")
        println("weekdayEvent : $weekdayEvent")
        println("weekendEvent : $weekendEvent")

    }
}