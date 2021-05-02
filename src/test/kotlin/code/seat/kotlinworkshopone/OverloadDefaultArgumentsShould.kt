package code.seat.kotlinworkshopone

import org.junit.jupiter.api.Test

class DefaultArgumentsShould {

    @Test
    internal fun `do not overload for default arguments on Kotlin`() {
        find("bike")
        find("bike", false)
    }

    fun find(name: String) {
        find(name, true)
    }

    fun find(name: String, recursive: Boolean) {}

    @Test
    internal fun `use named arguments on Kotlin instead`() {
        find2("bike")
    }

    fun find2(name: String, available: Boolean = true) {}
}
