package battleships

import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.ContentNegotiation
import io.ktor.features.DefaultHeaders
import io.ktor.gson.gson
import io.ktor.response.respond
import io.ktor.routing.get
import io.ktor.routing.routing

val game = Game(listOf(Squares.from("A1")))

fun Application.main() {
    install(DefaultHeaders)
    battleships(game)
}

fun Application.battleships(game: Game) {
    install(ContentNegotiation) { gson {} }
    routing {
        get("/") {
            (call.request.queryParameters["shots"] ?: "")
                .let { shots ->
                    call.respond(
                        ResultsModel.from(
                            game.assessShots(Squares.from(shots))
                        )
                    )
                }
        }
    }
}