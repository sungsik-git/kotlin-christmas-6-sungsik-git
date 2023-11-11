package transformation

class DivideOrder (private val input: List<String>) {

    fun getOrderMenuNames(): List<String>{
        val menus = input.map { it.split("-").first() }
        return menus
    }

    fun getOrderMenuAmount() : List<String>{
        val amounts = input.map { it.split("-").last() }
        return amounts
    }

}