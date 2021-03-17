package code.seat.kotlinworkshopone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExtensionFunctionsShould {

    @Test
    internal fun `do not use static methods in util classes on Kotlin`() {
        assertThat(StringUtil.countChars("seatCodeWorkshopKotlin", "o")).isEqualTo(4)
    }

    object StringUtil {
        fun countChars(string: String, char: String): Int {
            return string.length - string.replace("o", "").length
        }
    }

    @Test
    internal fun `use extension functions on Kotlin instead`() {
        assertThat("seatCodeWorkshopKotlin".countChars("o")).isEqualTo(4)
    }

    fun String.countChars(char: String): Int {
        return length - replace(char, "").length
    }
}
