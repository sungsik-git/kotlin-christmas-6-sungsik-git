package order

import userView.InputView
import userView.OutputView

class UserOrder {
    var inputView = InputView()
    fun start(){
        var visitDay = inputView.readDate()
        var orderMenus = inputView.readMenu()

        OutputView().printOrderDetail(visitDay,orderMenus)
    }
}