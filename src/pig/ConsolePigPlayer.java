// description: human pig player that uses the console as an interface
package pig;


import java.util.Scanner;

public class ConsolePigPlayer implements PigPlayer {
    private final Scanner scanner = new Scanner(System.in);
    private final java.io.PrintStream out;

    // Creates a ConsolePigPlayer that connects to console using System.in and java.util.Scanner.
    public ConsolePigPlayer (java.util.Scanner scanner, java.io.PrintStream out) {
        this.out = out;
    }

    // Returns whether the player wishes to roll again.
    @Override
    public boolean isRolling(int myScore, int otherScore, int turnTotal) {
        // ask user if they want to hold or roll
            out.print("Turn total: " + turnTotal + "\t" + "Roll/Hold? ");
            return scanner.nextLine().isEmpty();    // returns true if input is empty
    }
}
