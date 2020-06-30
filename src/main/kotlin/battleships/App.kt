package battleships

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.http.ContentType.Text.Html
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import kotlin.math.floor

fun Application.module() {
    install(Routing) {
        get("/") {
            call.respondText("Hello mum ${floor(100 * Math.random()).toInt()}", Html)
        }
    }
}

fun main() {
    embeddedServer(Netty, 8080, watchPaths = listOf("AppKt"), module = Application::module).start()
}
