package battleships

enum class Result(val char: Char) {
    HIT('H'), MISS('M'), SUNK('S')
}