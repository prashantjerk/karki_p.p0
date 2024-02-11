// description: an AI pig player that holds at X or when the player reaches the goal score to win the game.
package pig;

public class HoldAtXPigPlayer implements  PigPlayer{
    private final int numberHeldAt;
    // Creates a "hold at x or goal" AI pig player with the given x.
    public HoldAtXPigPlayer(int x)
    {
        numberHeldAt = x;
    }

    // Creates a "hold at x or goal" AI pig player with the given x
    @Override
    public boolean isRolling(int myScore, int otherScore, int turnTotal) {
        return (myScore < 100 && otherScore < 100 && turnTotal < this.numberHeldAt);
    }
}
