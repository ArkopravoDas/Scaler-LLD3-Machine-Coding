package tictactoe.strategy;

import tictactoe.models.Cell;
import tictactoe.models.CellState;
import tictactoe.models.Game;
import tictactoe.models.Player;

public class DiagonalWinningStrategy implements WinningStrategy {
    @Override
    public boolean isWinning(Game game) {
        return leftTopToRightBottomCheck(game) || rightTopToLeftBottom(game);
    }

    public boolean leftTopToRightBottomCheck(Game game) {
        Player currPlayer = game.playerList.get(game.currPlayerIndex);

        for (int i = 0; i < game.board.getN(); i++) {
            Cell curr = game.board.getCells().get(i).get(i);
            if (curr.getCellState().equals(CellState.FREE) || !curr.getPlayer().equals(currPlayer)) {
                return false;
            }
        }
        return true;
    }

    public boolean rightTopToLeftBottom(Game game) {
        Player currPlayer = game.playerList.get(game.currPlayerIndex);
        int N = game.board.getN();
        for (int i = 0; i < N; i++) {
            Cell curr = game.board.getCells().get(i).get(N - i - 1);
            if (curr.getCellState().equals(CellState.FREE) || !curr.getPlayer().equals(currPlayer)) {
                return false;
            }
        }
        return true;
    }
}
