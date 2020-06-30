package battleships

data class Squares(val squares: List<Square>) {
    companion object {
        fun from(input: String): Squares = Squares(splitStringOfSquares(input))
    }
}

data class Square(val col: Int, val row: Int)

private fun splitStringOfSquares(input: String): List<Square> {
    tailrec fun splitIntoAlternatingCharsAndDigits(
        input: String,
        position: Int,
        acc: List<String>
    ): List<String> =
        when {
            input.isEmpty() -> acc
            position >= input.length - 1 -> acc + input
            input[position].isDigit().xor(input[position + 1].isDigit()) ->
                splitIntoAlternatingCharsAndDigits(
                    input.slice(position + 1 until input.length),
                    0,
                    acc + input.slice(0..position)
                )
            else -> splitIntoAlternatingCharsAndDigits(
                input, position + 1, acc
            )
        }

    return splitIntoAlternatingCharsAndDigits(input, 0, emptyList())
        .chunked(2)
        .map {
            Square(it[0].first().toAlphabetPosition(), it[1].toInt())
        }
}

private fun Char.toAlphabetPosition(): Int = this.toInt() % 32
