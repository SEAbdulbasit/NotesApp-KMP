package database

import android.app.Application
import android.content.Context
import app.cash.sqldelight.async.coroutines.synchronous
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import org.notesapp.project.NotesDatabase

actual class DriverFactory {
    actual suspend fun createDriver(): SqlDriver {
        return AndroidSqliteDriver(NotesDatabase.Schema.synchronous(), Application(), "app.db")
    }
}