package evnet

class ApplyEvent (private val day: Int){
    fun test(){
        var testPrice = DdayEvent(day).applyDdayEvent()
        println(testPrice)
    }
}