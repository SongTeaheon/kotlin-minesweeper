package domain

import domain.position.PositionId
import domain.position.PositionIdFactory

class TestPositionIdFactory(private val returnValues: List<Int>) : PositionIdFactory {
    override fun positionIds(count: Int, positionIdMax: Int): List<PositionId> {
        return returnValues.map { PositionId(it) }
    }
}
