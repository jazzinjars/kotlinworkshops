package code.seat.kotlinworkshopone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NullabilityCheckShould {

    private val bike = Bike(Brand(Model("Trek - Emonda")))

    data class Bike(val brand: Brand?)
    data class Brand(val model: Model?)
    data class Model(val ref: String)

    @Test
    internal fun `do not check nullability like this on Kotlin`() {
        if (bike == null || bike.brand == null || bike.brand.model == null){
            throw IllegalArgumentException("Invalid Bike")
        }
        assertThat(bike.brand.model.ref).isEqualTo("Trek - Emonda")
    }

    @Test
    internal fun `use null-safe call or elvis operator on Kotlin instead`() {
        bike?.brand?.model?.ref ?: throw IllegalArgumentException("Invalid Bike")
        assertThat(bike.brand.model.ref).isEqualTo("Trek - Emonda")
    }

}
