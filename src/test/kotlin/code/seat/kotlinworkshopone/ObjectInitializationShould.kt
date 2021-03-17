package code.seat.kotlinworkshopone

import org.apache.commons.dbcp2.BasicDataSource
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ObjectInitializationShould {

    @Test
    internal fun `do not repeat variable name on Object Initialization on Kotlin`() {
        val dataSource = BasicDataSource()
        dataSource.driverClassName = "com.mysql.jdbc.Driver"
        dataSource.url = "jdbc:mysql://domain:3309/db"
        dataSource.username = "username"
        dataSource.password = "password"
        dataSource.maxTotal = 40
        dataSource.maxIdle = 40
        dataSource.minIdle = 4
        assertThat(dataSource.username).isEqualTo("username")
    }

    @Test
    internal fun `use apply for Grouping Object Initialization on Kotlin instead`() {
        val dataSource = BasicDataSource().apply {
            driverClassName = "com.mysql.jdbc.Driver"
            url = "jdbc:mysql://domain:3309/db"
            username = "username"
            password = "password"
            maxTotal = 40
            maxIdle = 40
            minIdle = 4
        }
        assertThat(dataSource.username).isEqualTo("username")
    }
}
