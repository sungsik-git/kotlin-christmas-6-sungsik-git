package userView

import evnet.DdayEvent
import evnet.RewardEvent
import evnet.SpecialEvent
import evnet.WeekdayEvent
import evnet.WeekendEvent
import transformation.CalculateInOrder
import transformation.DivideOrder
import transformation.VisitDayOfWeek

class OutputView() {
    fun printAll(day: Int, input: List<String>){
        printMenu(input)
        printTotalPrice(input)
        printReward(input)
        printEventDetail(day,input)
    }
    private fun printMenu(input: List<String>) {
        println("<주문 메뉴>")
        val orderNames = DivideOrder(input).getOrderMenuNames()
        val orderAmounts = DivideOrder(input).getOrderMenuAmount()

        for (index in 0 until orderAmounts.size){
            println("${orderNames[index]} ${orderAmounts[index]}개")
        }
    }

    private fun printEventDetail(day: Int, input: List<String>){
        val totalPrice = CalculateInOrder().TotalPriceInOrder(input)

        println("<혜택내역>")
        if(totalPrice >= 10000) {
            printApplyEvent(day, input)
        }else{
            println("없음")
        }
        println()
    }

    private fun printApplyEvent(visitDay: Int, orderMenus: List<String>) {

        val dDayEvent = DdayEvent(visitDay, orderMenus).applyDdayEvent()
        val dayOfWeeks = VisitDayOfWeek(visitDay).transformDayOfWeek()
        val weekdayEvent = WeekdayEvent(dayOfWeeks, orderMenus).applyWeekdayEvent()
        val weekendEvent = WeekendEvent(dayOfWeeks, orderMenus).applyWeekendEvent()
        val specialEvent = SpecialEvent(dayOfWeeks).applySpecialEvent()
        val rewardEvent = RewardEvent(orderMenus).applyRewardEvent()

        println("크리스마스 디데이 할인: -${dDayEvent}원")
        if(dayOfWeeks == "FRIDAY" || dayOfWeeks == "SATURDAY" ){
            println("주말 할인: -${weekendEvent}원")
        }else{
            println("평일 할인: -${weekdayEvent}원")
        }
        println("특별 할인: -${specialEvent}원")
        println("증정 이벤트: -${rewardEvent}원")
        println()
    }

    private fun printTotalPrice(input: List<String>){
        println("<할인 전 총주문 금액>")
        println("${CalculateInOrder().TotalPriceInOrder(input)}원")
        println()
    }

    private fun printReward(input: List<String>){
        val rewardEvent = RewardEvent(input).applyRewardEvent()
        println("<증정 메뉴>")
        if (rewardEvent != 0){
            println("샴페인 1개")
        }else{
            println("없음")
        }
        println()
    }
}