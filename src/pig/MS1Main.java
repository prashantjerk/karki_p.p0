// description: this class provides a main method and a console interface for milestone 1.
package pig;

import java.util.Scanner;

import static java.lang.System.out;

public class MS1Main {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        PigUI consoleInterface = new ConsoleInterface(input, out);

        Die die = new Die(consoleInterface.askUserForSeed());

        for(int i = 0; i < 10; i++) out.println(die.nextRoll());
    }
}

