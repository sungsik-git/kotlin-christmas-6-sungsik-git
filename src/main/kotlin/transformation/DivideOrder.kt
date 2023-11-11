package transformation

class DivideOrder (private val input: List<String>) {

    fun getOrderMenuNames(): List<String>{
        return input.map { it.split("-").first() }
    }

    fun getOrderMenuAmount(): List<String> {
        return input.map { it.split("-").last() }
    }


}