// description: an AI pig player that holds at X or when the player reaches the goal score to win the game.
package pig;

public class HoldAtXPigPlayer implements  PigPlayer{
    private final int numberHeldAt;
    public HoldAtXPigPlayer(int x)
    {
        numberHeldAt = x;
    }

    @Override
    public boolean isRolling(int myScore, int otherScore, int turnTotal) {
        return (turnTotal < this.numberHeldAt && myScore < 100 && otherScore < 100);
    }
}
