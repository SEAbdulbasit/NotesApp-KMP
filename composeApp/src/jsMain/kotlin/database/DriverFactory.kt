package database

import PlatformContext
import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver
import org.w3c.dom.Worker


actual class DriverFactory {
    actual suspend fun createDriver(platformContext: PlatformContext): SqlDriver {
        val driver = WebWorkerDriver(
            Worker(
                js("""new URL("@cashapp/sqldelight-sqljs-worker/sqljs.worker.js", import.meta.url)""")
            )
        )
        return driver
    }
}