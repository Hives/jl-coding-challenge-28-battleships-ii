package battleships

class Game(private val boats: List<Squares>) {
    fun assessShots(shots: Squares) = shots.squares.map { shot ->
        boats.find { boat ->
            boat.squares.contains(shot)
        }?.let { boat ->
            if (boat.isSunkBy(shots)) Result.SUNK
            else Result.HIT
        } ?: Result.MISS
    }

    private fun Squares.isSunkBy(shots: Squares) =
        this.squares.all { shots.squares.contains(it) }

    private val boatSquares: List<Square>
        get() = boats.flatMap {
            it.squares
        }
}