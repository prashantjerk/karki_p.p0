// description: this class exists only to provide the main method.
package pig;

import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ConsoleInterface instConsoleInterface = new ConsoleInterface(input, System.out);    // instantiate ConsoleInterface
        PigPlayer player1 = new ConsolePigPlayer(input, System.out);    // instantiate player1 as ConsolePigPlayer
        PigPlayer player2 = new HoldAtXPigPlayer(5);    // instantiate player2 as HoldAtXPigPlayer

        // instantiate new game
        PigGame game = new PigGame(player1, player2, instConsoleInterface.askUserForSeed(), instConsoleInterface);

        game.play();
    }
}