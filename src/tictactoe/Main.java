package tictactoe;

import tictactoe.controllers.GameController;
import tictactoe.models.Board;
import tictactoe.models.Game;
import tictactoe.models.GameState;

public class Main {
    public static void main(String[] args) {
        Game game = GameController.initializeGame();

        GameController gc = new GameController(game);

        while(game.getGameState().equals(GameState.IN_PROGRESS)){
            game.getBoard().displayBoard();
            // Prints the next player's move
            // Ask the user for an input
            gc.makeNextMove();
        }

        game.getBoard().displayBoard();
    }
}
