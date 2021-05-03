package code.seat.kotlinworkshopone

import org.junit.jupiter.api.Test
import org.assertj.core.api.Assertions.assertThat

class ScopeFunctionShould {

    private val studentExpected = Student("1234567", "Mary", "Smith")

    @Test
    fun `respond with the correct student using also function`() {
        val aStudent = Student().also {
            it.studentId = "1234567"
            it.name = "Mary"
            it.surname = "Smith"
        }

        assertThat(aStudent)
            .isEqualTo(studentExpected)
    }


    @Test
    fun `respond with the correct student using apply function`() {
        val aStudent = Student().apply {
            studentId = "1234567"
            name = "Mary"
            surname = "Smith"
        }

        assertThat(aStudent)
            .isEqualTo(studentExpected)
    }

    @Test
    fun `respond with the correct list using let function`() {
        var expectedList = listOf(5, 4, 4, 5)
        val numbers = mutableListOf("one", "two", "three", "four", "five")

//        var listInt = numbers.map { it.length }.filter { it > 3 }
//        listInt.plus(5)

        val listMoreOne =numbers.map { it.length }.filter { it > 3 }.let {
            it.plus(5)
        }

        assertThat(listMoreOne)
            .isEqualTo(expectedList)

    }

    @Test
    fun `respond with the correct length using let with non-null values`() {
        val str: String? = "Trek!"

        var lengthString = str?.let {
             it.length
        }

        assertThat(lengthString)
            .isEqualTo(5)
    }

    @Test
    fun `respond with the correct length using run with non-null values`() {
        val str: String? = "Trek!"

        var lengthString = str?.run {
            length
        }

        assertThat(lengthString)
            .isEqualTo(5)
    }

    @Test
    fun `respond with the correct string using function scope run`(){
        val bikeService = BikeService("Trek Emonda SL6 Disc", "DT Swiss")

//        bikeService.buyBike(bikeService.prepareBike() + " with wheels ${bikeService.wheels}")

        val result = bikeService.run {
            buyBike(prepareBike() + "with wheels $wheels")
        }

        assertThat(result)
            .isEqualTo("Result for bike: 'Trek Emonda SL6 Disc with wheels DT Swiss'")
    }

    @Test
    fun `respond with the correct list using function scope with`(){
        var content : MutableList<String>
        var lengthTable = 0
        val numbers = mutableListOf("one", "two", "three")

        with(numbers) {
            content = this
            lengthTable = this.size
        }

        assertThat(content)
            .isEqualTo(mutableListOf("one", "two", "three"))
        assertThat(lengthTable)
            .isEqualTo(3)
    }


    class BikeService(var name: String, var wheels: String) {
        fun prepareBike(): String = name
        fun buyBike(request: String): String = "Result for bike: '$request'"
    }

    //takeIf and takeUnless are another scope function if you are more interested about it you
    // can visit https://kotlinlang.org/docs/scope-functions.html
}
    data class Student(var studentId : String? = "1", var name : String? = "name", var surname : String? = "surname")
