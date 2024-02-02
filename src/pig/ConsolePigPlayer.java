// description: human pig player that uses the console as an interface
package pig;

public class ConsolePigPlayer implements PigPlayer {
    java.util.Scanner scanner;
    java.io.PrintStream out;

    // ConsolePigPlayer constructor
    public ConsolePigPlayer (java.util.Scanner scanner, java.io.PrintStream out) {
        this.scanner = scanner;
        this.out = out;
    }

    @Override
    public boolean isRolling(int myScore, int otherScore, int turnTotal) {
        // ask user if they want to hold or roll
            out.print("Turn total: " + turnTotal + "\t" + "Roll/Hold? ");
            return (scanner.nextLine().isEmpty());
    }
}
