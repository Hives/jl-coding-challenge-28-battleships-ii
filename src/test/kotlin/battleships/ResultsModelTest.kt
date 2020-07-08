package battleships

import assertk.assertThat
import assertk.assertions.containsExactly
import battleships.Result.HIT
import battleships.Result.MISS
import battleships.Result.SUNK
import org.junit.jupiter.api.Test

internal class ResultsModelTest {
    @Test
    fun `can convert a list of Results to the ResultsModel`() {
        val results = listOf(MISS, SUNK, HIT)
        val resultsModel = ResultsModel.from(results)
        assertThat(resultsModel.results).containsExactly('M', 'S', 'H')
    }
}