package code.seat.kotlinworkshopone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.*

class UseExpressionsShould {
    val grandPrixCountry = "france"

    @Test
    internal fun `do not use this type of expressions on kotlin`() {

        assertThat(getGrandPrixLocaleDontDoIt(grandPrixCountry)).isEqualTo(Locale.FRENCH)
    }

    fun getGrandPrixLocaleDontDoIt(grandPrixCountry: String): Locale {
        val grandPrixLower = grandPrixCountry.toLowerCase()
        if (grandPrixLower == "germany" || grandPrixLower == "austria") {
            return Locale.GERMAN
        }
        if (grandPrixLower == "usa" || grandPrixLower == "great britain") {
            return Locale.ENGLISH
        }
        if (grandPrixLower == "france") {
            return Locale.FRENCH
        }
        return Locale.ENGLISH
    }

    @Test
    internal fun `use this on kotlin instead`() {

        assertThat(getGrandPrixLocale(grandPrixCountry)).isEqualTo(Locale.FRENCH)
    }

    fun getGrandPrixLocale(grandPrixCountry: String) = when (grandPrixCountry.toLowerCase()) {
        "germany", "austria" -> Locale.GERMAN
        "usa", "great britain" -> Locale.ENGLISH
        "france" -> Locale.FRENCH
        else -> Locale.ENGLISH
    }
}
