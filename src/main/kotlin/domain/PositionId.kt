package domain

class PositionId(private val id: Int) {
    fun position(width: Int): Position {
        val row = id / width
        val col = id % width
        return Position(row, col)
    }
}
