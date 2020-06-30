package battleships

import assertk.assertThat
import assertk.assertions.isEqualTo
import io.ktor.application.Application
import io.ktor.http.HttpMethod.Companion.Get
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import org.junit.jupiter.api.Test

internal class AppKtTest {
    @Test
    fun `GET root route returns OK`() = withTestApplication(Application::main) {
        with(this.handleRequest(Get, "/")) {
            assertThat(response.status()).isEqualTo(OK)
        }
    }
}