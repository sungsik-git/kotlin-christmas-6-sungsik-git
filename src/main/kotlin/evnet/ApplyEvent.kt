package evnet

import transformation.CalculateInOrder
import transformation.VisitDayOfWeek

class ApplyEvent (private val visitDay: Int, private val orderMenus: List<String>){

    fun printEvent(){
        val dDayEvent = DdayEvent(visitDay).applyDdayEvent()
        val dayOfWeeks = VisitDayOfWeek(visitDay).transformDayOfWeek()
        val weekdayEvent = WeekdayEvent(dayOfWeeks, orderMenus).applyWeekdayEvent()
        val weekendEvent = WeekendEvent(dayOfWeeks, orderMenus).applyWeekendEvent()
        val specialEvent = SpecialEvent(dayOfWeeks).applySpecialEvent()
        val rewardEvent = RewardEvent(orderMenus).applyRewardEvent()

        val discount = dDayEvent + weekdayEvent + weekendEvent + specialEvent + rewardEvent
        println("discount : $discount")
        val badgeEvent = BadgeEvent().applyBadgeEvent(discount)

        println("visitDayOfWeek : $dayOfWeeks")
        println("dDayEvent : $dDayEvent")
        println("weekdayEvent : $weekdayEvent")
        println("weekendEvent : $weekendEvent")
        println("specialEvent : $specialEvent")
        println("rewardEvent : $rewardEvent")
        println("badgeEvent : $badgeEvent")
    }
}