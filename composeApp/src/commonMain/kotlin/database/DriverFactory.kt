package database

import PlatformContext
import app.cash.sqldelight.db.SqlDriver

expect class DriverFactory() {
    suspend fun createDriver(platformContext: PlatformContext): SqlDriver
} 