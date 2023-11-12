package evnet

class BadgeEvent {
    companion object {
        const val MINIMUM_DISCOUNT = 5000
        const val MIDDLE_DISCOUNT = 10000
        const val MAXIMUM_DISCOUNT = 20000
    }

    var badge = ""

    fun applyBadgeEvent(discount: Int): String {
        badge = when {
            MINIMUM_DISCOUNT <= discount && discount < MIDDLE_DISCOUNT -> "별"
            MIDDLE_DISCOUNT <= discount && discount < MAXIMUM_DISCOUNT -> "트리"
            MAXIMUM_DISCOUNT < discount -> "산타"
            else -> "없음"
        }
        return badge
    }

}