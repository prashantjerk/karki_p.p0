package test;

import pig.*;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/**
 * This class just tests whether your code will compile with my tests.
 * This class DOES NOT actually test your code.  It just ensures that it compiles.
 * Do not change this code.
 * @author Joe Meehean
 */
public class CompilationStub {
    public static void main(String[] args) {
        // ConsoleInterface constructor
        PigUI ui = new ConsoleInterface(new Scanner(in), out);

        // PigUI required methods
        int seed = ui.askUserForSeed();
        ui.displayRollResult(4);
        ui.displayCurrentScores(0,1);
        ui.displayPlayersTurn(1);
        ui.displayTurnResults(2, 5, 78);
        ui.displayGameOver(101, 75);

        // make a Die
        Die die = new Die(87);

        // player 1 is not smart
        // ensures interface isn't broken
        PigPlayer player1 = new PigPlayer(){
            public boolean isRolling(int myScore, int otherScore, int turnTotal) {
                // do nothing
                return true;
            }
        };

        // player 2 is a holdAtXAI
        PigPlayer player2 = new HoldAtXPigPlayer(5);

        // make the game
        PigGame game = new PigGame(player1, player2, seed, ui);

        // play the game
        game.play();
    }
}
