package menuName

enum class MenuName (
    val category: String,
    val price: Int
){
    MUSHROOM_SOUP("appetizer",6000),
    TAPAS("appetizer", 5500),
    CAESAR_SALAD("appetizer", 8000),

    T_BORN_STEAK("main", 55000),
    BARBECUE_RIBS("main",54000),
    SEA_FOOD_PASTA("main",35000),
    CHRISTMAS_PASTA("main",25000),

    CHOCOLATE_CAKE("dessert", 15000),
    ICE_CREAM("dessert",5000),

    ZERO_COKE("drink",3000),
    RED_WINE("drink",60000),
    CHAMPAGNE("drink",25000)

}