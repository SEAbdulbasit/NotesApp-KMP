package database

import PlatformContext
import app.cash.sqldelight.async.coroutines.awaitCreate
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import org.notesapp.project.NotesDatabase


actual class DriverFactory {
    actual suspend fun createDriver(platformContext: PlatformContext): SqlDriver {
        val driver: SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY)
        NotesDatabase.Schema.awaitCreate(driver)
        return driver
    }
}