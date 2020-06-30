package battleships

data class Square(val row: Int, val col: Int)

data class Boat(val squares: List<Square>)

class Game(private val boats: List<Boat>) {
    fun assessShots(shots: List<Square>): List<Result> = shots.map {
        if (boatSquares.contains(it)) Result.HIT
        else Result.MISS
    }

    private val boatSquares: List<Square>
        get() = boats.flatMap {
            it.squares
        }
}