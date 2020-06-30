package battleships

import assertk.assertThat
import assertk.assertions.containsExactly
import battleships.Result.HIT
import battleships.Result.MISS
import org.junit.jupiter.api.Test

internal class GameTest {
    @Test
    fun `assessing shot with no boats is a miss`() {
        val game = Game(emptyList())
        val results = game.assessShots(listOf(Square(0, 0)))
        assertThat(results).containsExactly(MISS)
    }

    @Test
    fun `gives correct response for one shot which is a hit`() {
        val boat = Boat(listOf(Square(2, 7), Square(3, 7)))
        val game = Game(listOf(boat))
        val results = game.assessShots(listOf(Square(2, 7)))
        assertThat(results).containsExactly(HIT)
    }

    @Test
    fun `gives correct response for one shot which is a hit and one which is a miss`() {
        val boat = Boat(listOf(Square(2, 7), Square(3, 7)))
        val game = Game(listOf(boat))
        val results = game.assessShots(listOf(Square(2, 7), Square(2, 8)))
        assertThat(results).containsExactly(HIT, MISS)
    }
}