package code.seat.kotlinworkshopone

import org.junit.jupiter.api.Test

class AdHocStructsCreationShould {

    @Test
    internal fun `listOf map of and to can be used to create structs on Kotlin`() {
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
    }
}
