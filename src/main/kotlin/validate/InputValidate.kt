package validate

import userView.ErrorMessage

class InputValidate {

    fun validateOfVisitDay(input: Int){
        try {
            checkVisitDayRange(input)
        }catch (e: IllegalArgumentException){
            println(e.message)
        }
    }

    private fun checkVisitDayRange(input : Int){
        if(input < 1 || input > 31)
            throw IllegalArgumentException(ErrorMessage.INVALID_DATE_MESSAGE.message)
    }
}