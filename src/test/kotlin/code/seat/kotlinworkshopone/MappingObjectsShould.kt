package code.seat.kotlinworkshopone

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class MappingObjectsShould {
    @Test
    internal fun `do not map Objects like this on Kotlin`() {
        val bikeDTO = mapToDTO(BikeEntity("Trek", "road", "Emonda"))
        assertThat(bikeDTO.model).isEqualTo("Emonda")
    }

    private fun mapToDTO(entity: BikeEntity): BikeDTO {
        return BikeDTO(type = entity.type, brand = entity.brand, model = entity.model)
    }

    @Test
    internal fun `map Objects with Expression Functions on Kotlin instead`() {
        val bike = BikeEntity("Trek", "road", "Emonda")
        val bikeDTO = bike.toDTO()
        assertThat(bikeDTO.model).isEqualTo("Emonda")

        // also secondary constructor can be used
        val constructorBikeDTO = BikeDTO(bike)
        assertThat(constructorBikeDTO.model).isEqualTo("Emonda")
    }

    private fun BikeEntity.toDTO() = BikeDTO(brand = brand, type = type, model = model)
}

data class BikeEntity(val brand: String, val type: String, val model: String)
data class BikeDTO(val brand: String, val type: String, val model: String) {
    constructor(bike: BikeEntity): this(
        brand = bike.brand,
        type = bike.type,
        model = bike.model,
    )
}


