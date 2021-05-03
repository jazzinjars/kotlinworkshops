package code.seat.kotlinworkshopone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ExtensionFunctionsShould {

    @Test
    fun `slugfy the string when the extension functions is our and does not exist as instance method in String class`(){
        assertThat("Hello Seat Code".slugify()).isEqualTo("hello-seat-code")
    }

    @Test
    fun `not be called our get because get(0) is a member function of String class`(){
        assertThat("Hello Seat Code".get(0)).isEqualTo('H')
    }

    @Test
    fun `call our extension function BE CAREFUL`(){
        assertThat("Hello Seat Code".toUpperCase())
            .isNotEqualTo("HELLO SEAT CODE")
    }


}

fun String.slugify() = this.toLowerCase().replace(" ", "-")

fun String.get(value : Int) = this

fun String.toUpperCase() = toLowerCase()


