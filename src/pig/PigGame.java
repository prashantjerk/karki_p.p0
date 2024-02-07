// description: coordinates the act of playing a game of Pig between two players
package pig;

public class PigGame {
    private static final int GOAL_SCORE = 100;
    private static final int PIG_DIE_ROLL = 1;
    private final PigPlayer player1;
    private final PigPlayer player2;
    private final PigUI gameUI;
    private final Die die;
    private int playerNumber;
    private int player1Score, player2Score, tempScore, rollResult;
    public PigGame(PigPlayer player1, PigPlayer player2, int seed, PigUI ui) {
        this.player1 = player1;
        this.player2 = player2;
        die = new Die(seed);
        gameUI = ui;
    }

    public void play(){
        gameUI.displayCurrentScores(player1Score, player2Score);
        gameUI.displayPlayersTurn(playerNumber);


        // run until one of the player scores 100
        while(player1Score < GOAL_SCORE || player2Score < GOAL_SCORE) {
            playerNumber = 1;
            gameUI.displayPlayersTurn(playerNumber);

             do {
                rollResult = die.nextRoll();
                gameUI.displayRollResult(rollResult);
                if(rollResult == 1) {
                    tempScore = 0;
                } else if (player1Score >= GOAL_SCORE) {
                    gameUI.displayGameOver(player1Score, player2Score);
                } else {
                    tempScore += rollResult;
                }
            } while(rollResult != 1 && player1.isRolling(player1Score, player2Score, tempScore));

            playerNumber = 2;   // change the player
            player1Score += tempScore;
            gameUI.displayTurnResults(playerNumber, tempScore, player1Score);
            gameUI.displayCurrentScores(player1Score, player2Score);

            gameUI.displayPlayersTurn(playerNumber);

            tempScore = 0;  // set the temp score back to 0

            do {
                rollResult = die.nextRoll();
                gameUI.displayRollResult(rollResult);
                if(rollResult == 1) {
                    tempScore = 0;
                } else if (player2Score >= GOAL_SCORE) {
                    gameUI.displayGameOver(player1Score, player2Score);
                } else {
                    tempScore += rollResult;
                }
            } while(player2.isRolling(player2Score, player1Score, tempScore) && rollResult != 1);

                player2Score += tempScore;
                gameUI.displayTurnResults(playerNumber, tempScore, player2Score);
                gameUI.displayCurrentScores(player1Score, player2Score);
                tempScore = 0;
        }
    }
}
