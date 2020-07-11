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

val game = listOf("B2B3B4B5B6", "E1F1G1H1", "D3D4D5", "H4H5", "I8I9", "E6", "A9")
    .map { Squares.from(it) }
    .let { Game(it) }

fun Application.main() {
    install(DefaultHeaders)
    battleships(game)
}

fun Application.battleships(game: Game) {
    install(ContentNegotiation) { gson {} }
    routing {
        get("/") {
            with(call) {
                Squares.from(request.queryParameters["shots"] ?: "")
                    .let { shots -> game.assessShots(shots) }
                    .let { results -> ResultsModel.from(results) }
                    .let { resultsModel -> respond(resultsModel) }
            }
        }
    }
}