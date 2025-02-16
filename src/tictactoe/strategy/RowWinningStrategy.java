package tictactoe.strategy;

import tictactoe.models.Game;

public class RowWinningStrategy implements WinningStrategy {

    @Override
    public boolean isWinning(Game game) {
        // TODO: Iterate over all the rows and decide if the game ends
        return false;
    }
}
