package evnet

import transformation.VisitDayOfWeek

class ApplyEvent (private val visitDay: Int, private val orderMenus: List<String>){
    fun test(){
        val dDayEvent = DdayEvent(visitDay).applyDdayEvent()
        val dayOfWeeks = VisitDayOfWeek(visitDay).transformDayOfWeek()
        val weekdayEvent = WeekdayEvent(dayOfWeeks, orderMenus).applyWeekdayEvent()
        val weekendEvent = WeekendEvent(dayOfWeeks, orderMenus).applyWeekendEvent()
        val specialEvent = SpecialEvent(dayOfWeeks).applySpecialEvent()
        val rewardEvent = RewardEvent(orderMenus).applyRewardEvent()

        println("visitDayOfWeek : $dayOfWeeks")
        println("dDayEvent : $dDayEvent")
        println("weekdayEvent : $weekdayEvent")
        println("weekendEvent : $weekendEvent")
        println("specialEvent : $specialEvent")
        println("rewardEvent : $rewardEvent")
    }
}