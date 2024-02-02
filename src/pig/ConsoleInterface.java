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

    // asks user for the seed and returns it
    @Override
    public int askUserForSeed() {
        out.println("What seed would you like?\n");
        return scanner.nextInt();
    }

    // displays the score of player 1 and 2
    @Override
    public void displayCurrentScores(int player1Score, int player2Score) {
        out.println("Player 1 score: " + player1Score);
        out.println("Player 2 score: " + player2Score);
    }

    // displays "Game Over"
    @Override
    public void displayGameOver(int player1Score, int player2Score) {
        out.println("Game Over!!!");
        displayCurrentScores(player1Score, player2Score);
    }

    // displays whose turn it is
    @Override
    public void displayPlayersTurn(int playerNumber) {
        out.format("It is player %d's turn.", playerNumber);
    }

    // displays what number appeared on rolling
    @Override
    public void displayRollResult(int diceRoll) {
        out.println("Roll" + diceRoll);
    }

    // displays turn score and the new score
    @Override
    public void displayTurnResults(int playerNumber, int turnTotal, int newScore) {
        out.println("Turn Total: " + turnTotal);
        out.println("New Score: " + newScore);
    }
}
