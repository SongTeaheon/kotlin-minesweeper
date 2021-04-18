package controller

import domain.Board
import domain.square.mine.MineFactory
import ui.InputView
import ui.ResultView

object MineSweeperController {
    fun run() {
        val gameData = InputView.askInfo()
        val board = Board(gameData)

        ResultView(gameData).printMineGameState(board.squares)
    }
}
