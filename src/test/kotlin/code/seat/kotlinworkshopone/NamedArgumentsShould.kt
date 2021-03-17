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
    internal fun `use named arguments on Kotlin instead`() {
        val bike = Bycicle2(discBrakes = true, model = "Emonda", type = "road", brand = "Trek")
        assertThat(bike.brand).isEqualTo("Trek")
    }
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

class Bycicle2(
    val brand: String,
    val type: String,
    val model: String,
    val discBrakes: Boolean = false
)
