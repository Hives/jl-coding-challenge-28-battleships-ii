//package battleships
//
//import io.ktor.application.Application
//import io.ktor.application.call
//import io.ktor.application.install
//import io.ktor.features.CallLogging
//import io.ktor.features.DefaultHeaders
//import io.ktor.http.ContentType.Text.Html
//import io.ktor.response.respondText
//import io.ktor.routing.Routing
//import io.ktor.routing.get
//import kotlin.math.floor
//
//fun Application.main() {
//    install(DefaultHeaders)
//    install(Routing) {
//        get("/") {
//            call.respondText("Hello mum ${floor(100 * Math.random()).toInt()}", Html)
//        }
//    }
//}
