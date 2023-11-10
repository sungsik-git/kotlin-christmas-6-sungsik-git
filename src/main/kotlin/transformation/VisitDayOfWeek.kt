package transformation

class VisitDayOfWeek(private val day: Int) {
        fun transformDayOfWeek(): String {
            return when (day % 7) {
                1 -> "FRIDAY"
                2 -> "SATURDAY"
                3 -> "SUNDAY"
                4 -> "MONDAY"
                5 -> "TUESDAY"
                6 -> "WEDNESDAY"
                0 -> "THURSDAY"
                else -> "INVALID DAY"
            }
    }
}
