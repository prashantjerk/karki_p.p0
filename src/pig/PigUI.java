package pig;

public interface PigUI {
    int askUserForSeed();
    void displayCurrentScores(int player1Score, int player2Scores);
    void displayGameOver(int player1Score, int player2Score);
    void displayPlayersTurn(int playerNumber);
    void displayRollResult(int diceRoll);
    void displayTurnResults(int playerNumber, int turnTotal, int newScore);
}
