package tictactoe.models;

import lombok.*;
import tictactoe.strategy.ColumnWinningStrategy;
import tictactoe.strategy.DiagonalWinningStrategy;
import tictactoe.strategy.RowWinningStrategy;
import tictactoe.strategy.WinningStrategy;

import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Game {
    public Board board;
    public List<Player> playerList;
    public int currPlayerIndex;
    public List<Cell> moves;
    GameState gameState;
    List<WinningStrategy> winningStrategies;
    Player winner;

    public Game(int n, List<Player> playerList) {
        this.board = new Board(n);
        this.playerList = playerList;
        this.currPlayerIndex = 0;
        this.moves = new ArrayList<>();
        this.gameState = GameState.IN_PROGRESS;
        winningStrategies = new ArrayList<>(List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()));
    }

    public void setWinner() {
        gameState = GameState.WINNING;
        winner = playerList.get(currPlayerIndex);
    }

    public void setDraw() {
        gameState = GameState.DRAW;
    }

    /**
     * This method makes the next player decide a move and updates the board.
     */

    public void makeMoveForCurrPlayer() {
        Player currPlayer = this.playerList.get(currPlayerIndex);
        Cell cell = currPlayer.makeMove();

        try {
            this.getBoard().updateBoard(cell, currPlayer);
            this.moves.add(cell);
        } catch (IllegalArgumentException e) {
            System.out.println("Please chooose a valid cell");
            makeMoveForCurrPlayer();
            return;
        }
    }

    public void postMoveWinnerCheck() {
        boolean isWin = this.getWinningStrategies().stream()
                .anyMatch(winningStrategy -> winningStrategy.isWinning(this));

        if(isWin){
            this.setWinner();
        } else {
            this.currPlayerIndex += 1;
            this.currPlayerIndex %= this.playerList.size();
        }
    }
}
