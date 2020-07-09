package battleships

import assertk.assertThat
import assertk.assertions.isEqualTo
import assertk.assertions.isTrue
import com.google.gson.JsonParser
import io.ktor.application.Application
import io.ktor.http.HttpMethod
import io.ktor.http.HttpStatusCode
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.jupiter.api.Test

internal class FunctionalTest {
    @Test
    fun `Application returns OK with json content`() {
        withTestApplication(Application::main) {
            with(handleRequest(HttpMethod.Get, "/?shots=H4H5H6")) {

                assertThat(response.status()).isEqualTo(HttpStatusCode.OK)

                val results = JsonParser.parseString(response.content).asJsonObject
                assertThat(results.has("results")).isTrue()
            }
        }
    }
}