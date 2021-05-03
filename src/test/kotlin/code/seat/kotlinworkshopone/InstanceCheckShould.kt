package code.seat.kotlinworkshopone

import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

/**
 * https://kotlinlang.org/docs/typecasts.html
 */
class InstanceCheckShould {

    @Test
    internal fun `type checking`() {
        assertThatThrownBy {
            makeMechanicWork(PicaTeclas())
        }.isInstanceOf(IllegalArgumentException::class.java)
    }

    @Test
    internal fun `type casting`() {
        assertThatThrownBy {
            makeMechanicWorkAlternative(PicaTeclas())
        }.isInstanceOf(IllegalArgumentException::class.java)
    }
}

interface Employee {
    fun work()
}
class Mechanic : Employee {
    override fun work() {
        println("works")
    }
}

class PicaTeclas : Employee {
    override fun work() {
        println("drinks coffe")
    }
}

fun makeMechanicWork(employee: Employee) {
    if (employee !is Mechanic) {
        throw IllegalArgumentException("No Mechanic")
    }
    employee.work()
}

fun makeMechanicWorkAlternative(employee: Employee) {
    employee as? Mechanic ?: throw IllegalArgumentException("No Mechanic")
    employee.work()
}


