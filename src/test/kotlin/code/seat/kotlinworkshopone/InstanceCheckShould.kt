package code.seat.kotlinworkshopone

import org.junit.jupiter.api.Test

class InstanceCheckShould {

    @Test
    internal fun `do not check type instance on Kotlin`() {
        // getBikeMechanic
    }

    @Test
    internal fun `use as? and ? on Kotlin instead`() {
        // getBikeMechanicKotlin
    }
}

interface Employee
class Mechanic : Employee {
    fun getMechanic() {}
}

fun getBikeMechanic(employee: Employee) {
    if (employee !is Mechanic) {
        throw IllegalArgumentException("No Mechanic")
    }
    employee.getMechanic()
}

fun getBikeMechanicKotlin(employee: Employee) {
    employee as? Mechanic ?: throw IllegalArgumentException("No Mechanic")
    employee.getMechanic()
}



