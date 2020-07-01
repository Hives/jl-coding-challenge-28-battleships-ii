package battleships

data class Squares(val squares: List<Square>) {
    companion object {
        fun from(input: String): Squares = Squares(splitStringOfSquares(input))
    }
}

data class Square(val col: Int, val row: Int)

private fun splitStringOfSquares(input: String): List<Square> {
    if (input.isEmpty()) return emptyList()

    tailrec fun splitIntoAlternatingCharsAndDigits(
        input: String,
        position: Int,
        acc: List<String>
    ): List<String> =
        when {
            position >= input.length -> acc + input
            input[position - 1].isDigit().xor(input[position].isDigit()) ->
                splitIntoAlternatingCharsAndDigits(
                    input.slice(position until input.length),
                    1,
                    acc + input.slice(0 until position)
                )
            else -> splitIntoAlternatingCharsAndDigits(
                input, position + 1, acc
            )
        }

    return splitIntoAlternatingCharsAndDigits(input, 1, emptyList())
        .chunked(2)
        .map {
            Square(it[0].first().toAlphabetPosition(), it[1].toInt())
        }
}

private fun Char.toAlphabetPosition(): Int = this.toInt() % 32
