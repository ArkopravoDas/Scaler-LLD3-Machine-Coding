package tictactoe.controllers;

import tictactoe.models.Game;
import tictactoe.models.HumanPlayer;
import tictactoe.models.Player;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameController {

    Game game;

    public GameController(Game game) {
        this.game = game;
    }

    public static Game initializeGame() {
        System.out.println("Enter the board size: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Player> playerList = new ArrayList<>();
        for(int i=0; i<n-1; i++){
            System.out.println("Enter the player name and the symbol");
            String name = sc.next();
            String symbol = sc.next();
            // TODO: Handle bot players as Input
            playerList.add(new HumanPlayer(name, symbol.charAt(0), i+1));
        }

        return new Game(n, playerList);

    }

    public void makeNextMove() {
        int currPlayerIndex = game.getCurrPlayerIndex();
        Player currPlayer = game.playerList.get(currPlayerIndex);

        System.out.printf("It's %s's move", currPlayer.getName());
        currPlayer.makeMove();

        // Increment the game index
        // Check if somebody won
    }
}
