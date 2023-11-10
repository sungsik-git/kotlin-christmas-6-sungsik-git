package userView

import camp.nextstep.edu.missionutils.Console
import validate.InputValidate

class InputView {

    val check = InputValidate()

    fun readDate(): Int {
        var input = 0
        println("12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)")

        while (true) {
            input = Console.readLine().toInt()
            check.validateOfVisitDay(input)
            break
        }
        return input
    }

    fun readMenu(): List<String> {
        println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)")
        val input = Console.readLine()
        val orderMenus = input.split(",").map { it.trim() }
        return orderMenus
    }
}