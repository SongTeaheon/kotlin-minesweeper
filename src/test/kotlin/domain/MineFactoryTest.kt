package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class MineFactoryTest {

    @Test
    fun `생성한 지뢰의 위치가 width와 height를 넘지 않는지 확인한다`() {
        val width = 10
        val height = 2
        val mineNum = 2
        val mineFactory = MineFactory()
        val mines = mineFactory.createMines(width, height, mineNum)

        assertThat(mines).hasSize(mineNum)
        assertThat(mines[0].position.row).isLessThan(height)
        assertThat(mines[0].position.col).isLessThan(width)
    }

    @ParameterizedTest
    @CsvSource(value = ["0,0,0", "1,0,1", "13,1,3", "19,1,9"])
    fun `random 값으로 특정 값이 나왔을 때, position으로 잘 변경되는지 확인한다`(positionId: Int, row: Int, col: Int) {
        val width = 10
        val height = 2
        val mineNum = 1
        val mineFactory = MineFactory(TestRandomPositionIdFactory(listOf(positionId)))
        val mines = mineFactory.createMines(width, height, mineNum)

        assertThat(mines).hasSize(mineNum)
        assertThat(mines[0].position.row).isEqualTo(row)
        assertThat(mines[0].position.col).isEqualTo(col)
    }
}