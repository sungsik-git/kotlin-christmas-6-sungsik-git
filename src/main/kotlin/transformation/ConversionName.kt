package transformation

import userView.MenuName

class ConversionName() {

    fun nameToCategory(orderMenuNames: List<String>) : MutableList<String>{
        var orderCategorys = mutableListOf<String>()

        for (orderMenuName in orderMenuNames) {
            val categoryName = MenuName.categoryFromName(orderMenuName)
            if (categoryName != null) {
                orderCategorys.add(categoryName)
            }
        }
        return orderCategorys
    }

    fun nameToPrice(orderMenuNames: List<String>) : MutableList<Int>{
        var orderPrices = mutableListOf<Int>()

        for (orderMenuName in orderMenuNames) {
            val categoryName = MenuName.priceForName(orderMenuName)
            if (categoryName != null) {
                orderPrices.add(categoryName)
            }
        }
        return orderPrices
    }
}