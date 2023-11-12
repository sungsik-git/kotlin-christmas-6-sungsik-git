package transformation

class CalculateInOrder {
    fun TotalPriceInOrder(input: List<String>) : Int{
        val orderMenuAmount = DivideOrder(input).getOrderMenuAmount()
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val orderMenuPrices = ConversionByName().nameToPrice(orderMenuNames)
        var totalPrice = 0
        for (index in 0 until orderMenuAmount.size){
            totalPrice += orderMenuAmount[index] * orderMenuPrices[index]
        }
        return totalPrice
    }
}