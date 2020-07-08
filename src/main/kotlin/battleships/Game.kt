package battleships

import battleships.Result.HIT
import battleships.Result.MISS
import battleships.Result.SUNK

class Game(private val boats: List<Squares>) {
    fun assessShots(shots: Squares) = shots.squares.map { shot ->
        boats.find { it.isHitBy(shot) }
            ?.let { boat ->
                if (boat.isSunkBy(shots)) SUNK
                else HIT
            } ?: MISS
    }

    private fun Squares.isHitBy(shot: Square) = this.squares.contains(shot)

    private fun Squares.isSunkBy(shots: Squares) =
        this.squares.all { shots.squares.contains(it) }
}