package validate

import transformation.DivideOrder
import userView.ErrorMessage
import userView.MenuName

class InputValidate {

    fun validateOfVisitDay(input: Int) {
        checkVisitDayRange(input)
    }

    fun validateOfMenuName(input: List<String>) {
        checkOrderMenuInMenuName(input)
        checkOrderMenuCount(input)
        checkSameMenuName(input)
    }

    private fun checkVisitDayRange(input: Int) {
        if (input < 1 || input > 31)
            throw IllegalArgumentException(ErrorMessage.INVALID_DATE_MESSAGE.message)
    }

    private fun checkOrderMenuInMenuName(input: List<String>) {
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val menuNames = MenuName.values().map { it.menuName }
        var checkMenuName = true

        for (orderMenuName in orderMenuNames) {
            checkMenuName = menuNames.contains(orderMenuName)
        }

        if (!checkMenuName)
            throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
    }

    private fun checkOrderMenuCount(input: List<String>) {
        println(input)
        if(input.all { !it.contains("-")} )
            throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
    }

    private fun checkSameMenuName(input: List<String>) {
        val orderMenuNames = DivideOrder(input).getOrderMenuNames()
        val removeSameOrderMenuName = orderMenuNames.distinct()

        if (orderMenuNames.size != removeSameOrderMenuName.size)
            throw IllegalArgumentException(ErrorMessage.INVALID_ORDER_MESSAGE.message)
    }
}