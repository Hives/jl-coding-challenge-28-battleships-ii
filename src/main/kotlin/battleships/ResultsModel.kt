package battleships

data class ResultsModel(val results: List<Char>) {
    companion object {
        fun from(results: List<Result>) = ResultsModel(results.map { it.char })
    }
}