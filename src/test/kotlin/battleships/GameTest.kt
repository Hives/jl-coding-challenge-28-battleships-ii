package battleships

import assertk.assertThat
import assertk.assertions.containsExactly
import battleships.Result.*
import org.junit.jupiter.api.Test

internal class GameTest {
    @Test
    fun `assessing shot with no boats is a miss`() {
        val game = Game(emptyList())
        val shots = Squares(listOf(Square(0, 0)))
        val results = game.assessShots(shots)
        assertThat(results).containsExactly(MISS)
    }

    @Test
    fun `gives correct response for one shot which is a hit`() {
        val game = Game(listOf(Squares.from("B7C7")))
        val shots = Squares.from("B7")
        val results = game.assessShots(shots)
        assertThat(results).containsExactly(HIT)
    }

    @Test
    fun `gives correct response for one shot which is a hit and one which is a miss`() {
        val game = Game(listOf(Squares.from("B7C7")))
        val shots = Squares.from("B7B8")
        val results = game.assessShots(shots)
        assertThat(results).containsExactly(HIT, MISS)
    }

    @Test
    fun `returns SUNK if all squares of a boat are hit`() {
        val game = Game(
            listOf(
                Squares.from("B7C7"),
                Squares.from("E10E11")
            )
        )
        val shots = Squares.from("A1B7C7E10")
        val results = game.assessShots(shots)
        assertThat(results).containsExactly(MISS, SUNK, SUNK, HIT)
    }
}