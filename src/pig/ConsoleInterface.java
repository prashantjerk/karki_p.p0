// description: this class provides a console interface for a pig game
package pig;

import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleInterface implements PigUI {
    private final java.util.Scanner scanner;
    private final java.io.PrintStream out;

    // constructor
    public ConsoleInterface(java.util.Scanner scanner, java.io.PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    // This method ask's the user for a seed for the game
    @Override
    public int askUserForSeed() {
        out.println("What seed would you like? ");
        return scanner.nextInt();
    }

    // Prints the player's scores to the console.
    @Override
    public void displayCurrentScores(int player1Score, int player2Score) {
        out.println("Player 1 score: " + player1Score);
        out.println("Player 2 score: " + player2Score);
    }

    // Prints "Game Over!!!" to the console.
    @Override
    public void displayGameOver(int player1Score, int player2Score) {
        out.println("Game Over!!!");
    }

    // Prints whose turn it is to console.
    @Override
    public void displayPlayersTurn(int playerNumber) {
        out.format("It is player %d's turn.\n", playerNumber);
    }

    // Prints "Roll: " and then the dice roll
    @Override
    public void displayRollResult(int diceRoll) {
        out.println("Roll: " + diceRoll);
    }

    // Prints the turn results to the console.
    @Override
    public void displayTurnResults(int playerNumber, int turnTotal, int newScore) {
        out.println("Turn Total: " + turnTotal);
        out.println("New Score: " + newScore);
    }
}
