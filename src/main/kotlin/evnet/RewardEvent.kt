package evnet

import transformation.CalculateInOrder
import transformation.ConversionByName
import transformation.DivideOrder

class RewardEvent (orderMenus: List<String>) {
    var onTarget = false
    var discount = 0
    init {
        if(CalculateInOrder().TotalPriceInOrder(orderMenus) > 1200000) onTarget = true
    }

    fun applyRewardEvent() : Int{
        if(onTarget){
            discount += 25000
        }
        return discount
    }

}