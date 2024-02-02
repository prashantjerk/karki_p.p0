// description: a class which represents an n-sided dice.
package pig;

import java.util.Random;

public class Die {
    private final int diceSides = 6;
    Random rand = new Random();             // an instance of Random
    private final int[] sides;              // declared outside so that nextRoll() can access
                                            // final because the sides will remain the way it is

    // description: creates a standard six-sided die, with possible outcomes 1, 2, 3, 4, 5, and 6.
    public Die(int seed)
    {
        sides = new int[diceSides];         // create an array for 6 sides of a die
        rand.setSeed(seed);

        for (int i = 0; i < diceSides; i++) // creates an array of 1 to 6
            sides[i] = i + 1;
    }

    // description: creates a die with side-values specified by given array
    public Die(int seed, int[] outcomes)
    {
        rand.setSeed(seed);

        // make a copy of outcomes because arrays are immutable, and
        // we should always make a copy of mutable objects when passed as an argument
        sides = new int[outcomes.length];
        for (int i = 0; i < outcomes.length; i++)
            sides[i] = outcomes[i];
    }

    // description: returns the result of rolling the dice
    public int nextRoll()
    {
        return sides[rand.nextInt(diceSides)];
    }
}
