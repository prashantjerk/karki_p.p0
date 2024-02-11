// description: coordinates the act of playing a game of Pig between two players
package pig;

public class PigGame {
    private static final int GOAL_SCORE = 100;
    private static final int PIG_DIE_ROLL = 1;
    private final PigPlayer player1;
    private final PigPlayer player2;
    private final PigUI gameUI;
    private final Die die;
    private int player1Score;
    private int player2Score;
    private int tempScore;


    // Create a new game of pig with players 1 and 2.
    public PigGame(PigPlayer player1, PigPlayer player2, int seed, PigUI ui) {
        this.player1 = player1;
        this.player2 = player2;
        die = new Die(seed);
        gameUI = ui;
    }

    // Plays a single game of Pig between two players.
    public void play(){
        gameUI.displayCurrentScores(player1Score, player2Score);

        // run until one of the players score GOAL_SCORE (100)
        while(player1Score < GOAL_SCORE && player2Score < GOAL_SCORE) {
            int playerNumber = 1;
            gameUI.displayPlayersTurn(playerNumber);

            int rollResult;     // the variable to store roll everytime
            int couldBeScore;   // the possible score if the player hadn't scored PIG_DIE_ROLL (1)
            do {
                rollResult = die.nextRoll();    // roll the die
                gameUI.displayRollResult(rollResult);   // display the roll to the console
                if(rollResult == PIG_DIE_ROLL) {
                    tempScore = 0;  // if rolled 1, set the tempScore to 0
                } else {
                    tempScore += rollResult;    // else keep adding each roll
                }
                couldBeScore = player1Score + tempScore;    // stores the sum current tempScore and player1Score
                // keep giving another roll to player 1 if
                // the couldBeScore is less than 100 AND
                // the roll is not equal to 1 AND
                // player 1 chooses to roll again
            } while(rollResult != PIG_DIE_ROLL && couldBeScore < GOAL_SCORE && player1.isRolling(player1Score, player2Score, tempScore));

            playerNumber = 2;   // change the player
            player1Score += tempScore;  // update the player1Score
            gameUI.displayTurnResults(playerNumber, tempScore, player1Score);   // display the number scored in the turn
            gameUI.displayCurrentScores(player1Score, player2Score);    // display the current score

            gameUI.displayPlayersTurn(playerNumber);    // display who is playing

            tempScore = 0;  // set the tempScore back to 0
            // this loop is similar to the above loop, except fot isRolling() and variable player2Score
            do {
                rollResult = die.nextRoll();
                gameUI.displayRollResult(rollResult);
                if(rollResult == PIG_DIE_ROLL) {
                    tempScore = 0;
                } else {
                    tempScore += rollResult;
                }
                couldBeScore = player2Score + tempScore;
            } while(couldBeScore < GOAL_SCORE && player2.isRolling(player2Score, player1Score, tempScore) && rollResult != PIG_DIE_ROLL);

                player2Score += tempScore;
                gameUI.displayTurnResults(playerNumber, tempScore, player2Score);
                if(player1Score >= GOAL_SCORE || player2Score >= GOAL_SCORE)
                {   // if any of the players reach the target score, call displayGameOver()
                    gameUI.displayGameOver(player1Score, player2Score);
                }
                gameUI.displayCurrentScores(player1Score, player2Score);
                tempScore = 0;
        }
    }
}







