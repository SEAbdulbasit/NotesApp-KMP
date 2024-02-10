import app.cash.sqldelight.db.SqlDriver

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform

expect class DriverFactory {
    fun createDriver(): SqlDriver
}