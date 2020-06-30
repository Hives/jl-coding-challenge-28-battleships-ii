package battleships

import assertk.assertThat
import assertk.assertions.containsExactly
import assertk.assertions.isEmpty
import org.junit.jupiter.api.Test

internal class SquaresTest {
    @Test
    fun `empty string gives no squares`() {
        assertThat(Squares.from("").squares).isEmpty()
    }

    @Test
    fun `translates column A to 1`() {
        assertThat(Squares.from("A1").squares).containsExactly(Square(1, 1))
    }

    @Test
    fun `translates column Z to 26`() {
        assertThat(Squares.from("Z1").squares).containsExactly(Square(26, 1))
    }

    @Test
    fun `can split a string of 5 coordinates into separate squares`() {
        assertThat(Squares.from("A1B2C3D4E5").squares)
            .containsExactly(
                Square(1, 1),
                Square(2, 2),
                Square(3, 3),
                Square(4, 4),
                Square(5, 5)
            )
    }

    @Test
    fun `can split squares if they have a really long sequence of numbers`() {
        assertThat(Squares.from("A123456789B2").squares)
            .containsExactly(
                Square(1, 123456789),
                Square(2, 2)
            )
    }
}
