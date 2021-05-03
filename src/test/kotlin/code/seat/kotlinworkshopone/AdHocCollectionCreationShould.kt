package code.seat.kotlinworkshopone

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

/**
 * https://kotlinlang.org/docs/constructing-collections.html#construct-from-elements
 */
class AdHocCollectionCreationShould {

    @Test
    internal fun `mapOf and listOf can be used to create immutable collections`() {
        val camera = mapOf(
            "brand" to "Sony",
            "model" to "A7 III",
            "megapixels" to 24,
            "video" to listOf("fullHD", "4k"),
            "focus" to mapOf(
                "points" to 432,
                "type" to listOf("center", "wide")
            )
        )

        // there are extension functions to convert them to their mutable parts
        val mutableCamera = camera.toMutableMap()
        mutableCamera["price"] = 3000
        Assertions.assertThat(mutableCamera["price"]).isEqualTo(3000)
        Assertions.assertThat(camera["price"]).isNull()
    }

    @Test
    internal fun `there is also mutable counterparts of all the collections`() {
        val camera = mutableMapOf(
            "brand" to "Sony",
            "model" to "A7 III",
            "megapixels" to 24,
            "video" to listOf("fullHD", "4k"),
            "focus" to mapOf(
                "points" to 432,
                "type" to listOf("center", "wide")
            )
        )

        camera["price"] = 3000

        Assertions.assertThat(camera["price"]).isEqualTo(3000)
    }

    @Test
    internal fun `there are empty collection creators`() {
        val cameras = emptyList<Map<String,Any>>()
        val camera = emptyMap<String, Any>()
        val scores = emptySet<Int>()

        Assertions.assertThat(cameras.size).isEqualTo(0)
        Assertions.assertThat(camera.size).isEqualTo(0)
        Assertions.assertThat(scores.size).isEqualTo(0)
    }
}
