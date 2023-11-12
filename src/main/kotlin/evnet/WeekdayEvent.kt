package evnet

import transformation.ConversionName
import transformation.DivideOrder

class WeekdayEvent (day: String, input: List<String>){
    companion object{
        val weekDays = listOf("SUNDAY", "MONDAY", "TUESDAY", "WEDNESDAY", "THURSDAY")
    }

    private var onTarget = false
    private var discount = 0
    private var totalDessertAmount = 0

    init {
        if(weekDays.contains(day) && amountOfDessertInOrder(input) != 0){
            onTarget = true
        }
    }

    fun applyWeekdayEvent() : Int{
        if(onTarget) {
            discount += 2023 * totalDessertAmount
        }
        return discount
    }

    fun amountOfDessertInOrder(input: List<String>) :Int{
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val orderMenuCategorys = ConversionName().nameToCategory(orderMenuNames)
        val indexs = mutableListOf<Int>()


        for(index in 0 until orderMenuCategorys.size){
            if (orderMenuCategorys[index] == "DESSERT") indexs.add(index)
        }

        totalDessertAmount = searchDessertInCategory(input, indexs)

        return totalDessertAmount
    }

    fun searchDessertInCategory(input: List<String>, indexs: MutableList<Int>) : Int{
        val orderMenuAmounts = DivideOrder(input).getOrderMenuAmount()
        var totalDessertAmount = 0

        for(index in indexs) {
            totalDessertAmount += orderMenuAmounts[index]
        }
        return totalDessertAmount
    }
}