package christmas

import camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest
import camp.nextstep.edu.missionutils.test.NsTest
import evnet.BadgeEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import userView.ErrorMessage


class ApplicationTest : NsTest() {
    @Test
    fun `모든 타이틀 출력`() {
        assertSimpleTest {
            run("3", "티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1")
            assertThat(output()).contains(
                "<주문 메뉴>",
                "<할인 전 총주문 금액>",
                "<증정 메뉴>",
                "<혜택 내역>",
                "<총혜택 금액>",
                "<할인 후 예상 결제 금액>",
                "<12월 이벤트 배지>"
            )
        }
    }

    @Test
    fun `혜택 내역 없음 출력`() {
        assertSimpleTest {
            run("26", "타파스-1,제로콜라-1")
            assertThat(output()).contains("<혜택 내역>$LINE_SEPARATOR".toString() + "없음")
        }
    }

    @Test
    fun `날짜 예외 테스트`() {
        assertSimpleTest {
            runException("a")
            assertThat(output()).contains("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `주문 예외 테스트`() {
        assertSimpleTest {
            runException("3", "제로콜라-a")
            assertThat(output()).contains("[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요.")
        }
    }

    @Test
    fun `방문 날짜가 1~31일 사이의 값이 아닐 경우 예외 발생`(){
        assertSimpleTest {
            runException("32")
            assertThat(output()).contains(ErrorMessage.INVALID_DATE_MESSAGE.message)
        }
    }

    @Test
    fun `메뉴에 없는 상품을 주문할 경우 예외 발생`(){
        assertSimpleTest {
            runException("13", "치킨-2,피자-1")
            assertThat(output()).contains(ErrorMessage.INVALID_ORDER_MESSAGE.message)
        }
    }

    @Test
    fun `메뉴를 20개 이상 주문 할 경우 예외 발생`(){
        assertSimpleTest {
            runException("13", "타파스-11,제로콜라-10")
            assertThat(output()).contains(ErrorMessage.INVALID_ORDER_MESSAGE.message)
        }
    }

    @Test
    fun `메뉴를 1개도 주문하지 않을 경우 예외 발생`(){
        assertSimpleTest {
            runException("13", "타파스-0")
            assertThat(output()).contains(ErrorMessage.INVALID_ORDER_MESSAGE.message)
        }
    }

    @Test
    fun `음료 메뉴만 주문했을 때 예외 발생`(){
        assertSimpleTest {
            runException("13", "제로콜라-1")
            assertThat(output()).contains(ErrorMessage.INVALID_ORDER_MESSAGE.message)
        }
    }

    @Test
    fun `혜택 금액별 해당되는 뱃지 지급`(){
        assertSimpleTest {
            var badge = BadgeEvent().applyBadgeEvent(5000)
            assertThat(badge).isEqualTo("별")
            badge = BadgeEvent().applyBadgeEvent(10000)
            assertThat(badge).isEqualTo("트리")
            badge = BadgeEvent().applyBadgeEvent(20000)
            assertThat(badge).isEqualTo("산타")
        }
    }

    override fun runMain() {
        main()
    }

    companion object {
        private val LINE_SEPARATOR = System.lineSeparator()
    }
}
