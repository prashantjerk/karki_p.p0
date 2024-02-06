// description: coordinates the act of playing a game of Pig between two players
package pig;

public class PigGame {
    private static final int GOAL_SCORE = 100;
    private static final int PIG_DIE_ROLL = 1;
    private final PigPlayer player1;
    private final PigPlayer player2;
    private final PigUI gameUI;
    private final Die die;
    private int playerNumber = 1;
    private int player1Score, player2Score, tempScore;
    public PigGame(PigPlayer player1, PigPlayer player2, int seed, PigUI ui) {
        this.player1 = player1;
        this.player2 = player2;
        die = new Die(seed);
        gameUI = ui;
    }

    public void play(){
        gameUI.displayCurrentScores(player1Score, player2Score);
        gameUI.displayPlayersTurn(playerNumber);

        int rollResult = die.nextRoll();  // this generates random roll
        tempScore += rollResult;
        gameUI.displayRollResult(rollResult); // this displays the rollResult

        // run until one of the player scores 100
        while(player1Score < GOAL_SCORE || player2Score < GOAL_SCORE) {
            while(player1.isRolling(player1Score, player2Score, tempScore)) {
                rollResult = die.nextRoll();
                if(rollResult == 1) {
                    tempScore = 0;
                    gameUI.displayTurnResults(playerNumber, tempScore, player1Score);
                } else {
                    tempScore += rollResult;
                }
                gameUI.displayRollResult(rollResult);
            }
            playerNumber = 2;   // change the player
            player1Score += tempScore;
            gameUI.displayTurnResults(playerNumber, tempScore, player1Score);
            gameUI.displayCurrentScores(player1Score, player2Score);

            gameUI.displayPlayersTurn(playerNumber);

            tempScore = 0;  // set the temp score back to 0
            while(player2.isRolling(player2Score, player1Score, tempScore)){
            rollResult = die.nextRoll();
            if(rollResult == 1) {
                tempScore = 0;
                gameUI.displayTurnResults(playerNumber, tempScore, player2Score);
            } else {
                gameUI.displayRollResult(rollResult);
            }
            }
        }
        /*
Before each turn, it should update the UI to display the current scores.
During each turn, it should update the UI to display the die rolls.
After each turn, it should update the UI to display the turn results.
At the end of the game, it should update the UI to display game over.
         */


    }
}
