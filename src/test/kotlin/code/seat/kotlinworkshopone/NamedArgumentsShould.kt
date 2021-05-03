package code.seat.kotlinworkshopone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NamedArgumentsShould {

    @Test
    internal fun `do not use fluent setter on Kotlin`() {
        val bike = Bicycle()
            .setBrand("Trek")
            .setType("road")
            .setModel("Emonda")
            .setDiscBrakes(true)
        assertThat(bike.brand).isEqualTo("Trek")
    }

    @Test
    internal fun `use named arguments on Kotlin data class instead`() {
        val bike = Bycicle2(discBrakes = true, model = "Emonda", type = "road", brand = "Trek")
        val bikeWithoutDiscBrakes = Bycicle2( model = "Emonda", type = "road", brand = "Trek")
        assertThat(bike.brand).isEqualTo("Trek")
        assertThat(bikeWithoutDiscBrakes.discBrakes).isFalse
    }

    @Test
    internal fun `creator functions or object mothers can be used for default parameters for test readability`() {
        val t22 = createDefaultBycicle(
            model = "T22"
        )

        assertThat(t22.model).isEqualTo("T22")
        assertThat(t22.brand).isEqualTo("ORBEA")
    }

    @Test
    internal fun `use named arguments on Kotlin function instead`() {
        val greetResp = greetMany("Hello", "Fernando", "Jaume", "Hector", "Víctor")

        assertThat(greetResp)
                .isEqualTo("Hello Fernando Jaume Hector Víctor and Welcome to the jungle")
    }

    private fun greetMany(many : String, vararg names : String, message : String = "Welcome to the jungle") =
             "$many ${names.joinToString(" ")} and $message"
}

class Bicycle {
    var brand: String? = null
    var type: String? = null
    var model: String? = null
    var discBrakes: Boolean? = false

    fun setBrand(brand: String): Bicycle {
        this.brand = brand
        return this
    }
    fun setType(type: String): Bicycle {
        this.type = type
        return this
    }
    fun setModel(model: String): Bicycle {
        this.model = model
        return this
    }
    fun setDiscBrakes(discBrakes: Boolean): Bicycle {
        this.discBrakes = discBrakes
        return this
    }
}

data class Bycicle2(
    val brand: String? = null,
    val type: String? = null,
    val model: String? = null,
    val discBrakes: Boolean = false
)


fun createDefaultBycicle(
    brand: String? = "ORBEA",
    type: String? = "mountain",
    model: String? = "T25",
    discBrakes: Boolean = false
) = Bycicle2(
    brand = brand,
    type = type,
    model = model,
    discBrakes = discBrakes,
)