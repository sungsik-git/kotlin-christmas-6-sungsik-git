package evnet

import transformation.ConversionName
import transformation.DivideOrder

class RewardEvent (orderMenus: List<String>) {
    var onTarget = false
    var discount = 0
    init {
        if(totalPriceOrderMenus(orderMenus) > 1200000) onTarget = true
    }

    fun applyRewardEvent() : Int{
        if(onTarget){
            discount += 25000
        }
        return discount
    }

    private fun totalPriceOrderMenus(input: List<String>) :Int{
        val orderMenuAmount = DivideOrder(input).getOrderMenuAmount()
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val orderMenuPrices = ConversionName().nameToPrice(orderMenuNames)
        var totalPrice = 0
        for (index in 0 until orderMenuAmount.size){
            totalPrice += orderMenuAmount[index] * orderMenuPrices[index]
        }
        return totalPrice
    }
}