package battleships

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.DefaultHeaders
import io.ktor.http.ContentType.Text.Html
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get

fun Application.main() {
    install(DefaultHeaders)
    install(Routing) {
        get("/") {
            val game = Game(listOf(Boat(listOf(Square(1, 1)))))
            call.request.queryParameters["shots"]
                ?.let { shots ->
                    val result = game.assessShots(Squares.from(shots))
                    call.respondText("Hello ${result.map { it.char }}", Html)
                }
                ?: call.respondText("Sadface :(", Html)
        }
    }
}
