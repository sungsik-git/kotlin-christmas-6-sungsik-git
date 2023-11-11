package order

import evnet.ApplyEvent
import userView.InputView

class UserOrder {
    var inputView = InputView()
    fun start(){
        var visitDay = inputView.readDate()
        var orderMenus = inputView.readMenu()

        ApplyEvent(visitDay, orderMenus).test()
    }
}