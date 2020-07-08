package battleships

import assertk.assertThat
import assertk.assertions.isEqualTo
import battleships.Result.HIT
import battleships.Result.MISS
import battleships.Result.SUNK
import com.google.gson.JsonParser
import io.ktor.http.HttpMethod.Companion.Get
import io.ktor.http.HttpStatusCode.Companion.OK
import io.ktor.server.testing.handleRequest
import io.ktor.server.testing.withTestApplication
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import org.junit.jupiter.api.Test

internal class AppKtTest {
    @Test
    fun `game route passes shots parameter to game and returns result as json`() {
        val slot = slot<Squares>()
        val mockGame = mockk<Game> {
            every { assessShots(capture(slot)) } returns listOf(HIT, MISS, SUNK)
        }

        withTestApplication({ battleships(mockGame) }) {
            with(handleRequest(Get, "/?shots=A1B2C3")) {
                assertThat(slot.captured).isEqualTo(Squares.from("A1B2C3"))

                assertThat(response.status()).isEqualTo(OK)

                val results = JsonParser.parseString(response.content).asJsonObject
                assertThat(results["results"].asJsonArray[0].asString).isEqualTo("H")
                assertThat(results["results"].asJsonArray[1].asString).isEqualTo("M")
                assertThat(results["results"].asJsonArray[2].asString).isEqualTo("S")
            }
        }
    }

    @Test
    fun `shots default to empty string if parameter not provided`() {
        val slot = slot<Squares>()
        val mockGame = mockk<Game> {
            every { assessShots(capture(slot)) } returns emptyList()
        }

        withTestApplication({ battleships(mockGame) }) {
            handleRequest(Get, "/")
            assertThat(slot.captured).isEqualTo(Squares.from(""))
        }
    }
}