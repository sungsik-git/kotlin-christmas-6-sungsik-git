package christmas

import evnet.ApplyEvent
import order.MenuName

fun main() {
    val testMenu = listOf("양송이수프", "티본스테이크", "초코케이크", "제로콜라")
    ApplyEvent(24,testMenu).test()


    val test = "양송이수프"
    val category = MenuName.categoryFromName(test)
    println("Category for $test: $category")
}
