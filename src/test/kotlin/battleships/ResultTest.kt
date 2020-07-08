package battleships

import assertk.assertThat
import assertk.assertions.isEqualTo
import battleships.Result.HIT
import battleships.Result.MISS
import battleships.Result.SUNK
import org.junit.jupiter.api.Test

internal class ResultTest {
    @Test
    fun `MISS char is 'M'`() {
        assertThat(MISS.char).isEqualTo('M')
    }

    @Test
    fun `HIT to string is "H"`() {
        assertThat(HIT.char).isEqualTo('H')
    }

    @Test
    fun `SUNK to string is "H"`() {
        assertThat(SUNK.char).isEqualTo('S')
    }
}