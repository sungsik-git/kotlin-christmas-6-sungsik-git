package userView

enum class MenuName (
    val menuName: String,
    val category: String,
    val price: Int
){
    양송이수프("양송이수프", "appetizer", 6000),
    타파스("타파스", "appetizer", 5500),
    시저샐러드("시저샐러드", "appetizer", 8000),

    타본스테이크("타본스테이크", "main", 55000),
    바비큐립("바비큐립", "main", 54000),
    해산물파스타("해산물파스타", "main", 35000),
    크리스마스파스타("크리스마스파스타", "main", 25000),

    초코케이크("초코케이크", "dessert", 15000),
    아이스크림("아이스크림", "dessert", 5000),

    제로콜라("제로콜라", "drink", 3000),
    레드와인("레드와인", "drink", 60000),
    샴페인("샴페인", "drink", 25000);


    companion object {
        fun categoryFromName(name: String): String? =
            values().find { it.menuName == name }?.category
    }
}