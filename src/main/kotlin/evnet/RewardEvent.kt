package evnet

import transformation.CalculateInOrder

class RewardEvent (orderMenus: List<String>) {
    companion object{
        const val MINIMUM_ORDER_PRICE = 120000
    }

    var onTarget = false
    var discount = 0
    init {
        if(CalculateInOrder().totalPriceInOrder(orderMenus) > MINIMUM_ORDER_PRICE) onTarget = true
    }

    fun applyRewardEvent() : Int{
        if(onTarget){
            discount += 25000
        }
        return discount
    }

}