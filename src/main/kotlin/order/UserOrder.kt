package order

import evnet.ApplyEvent
import userView.InputView

class UserOrder {
    fun start(){
        var visitDay = InputView().readDate()
        var orderMenus = InputView().readMenu()

        ApplyEvent(visitDay, orderMenus).test()
    }
}