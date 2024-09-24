package ru.nsu.game;

/**
 * Class that stores scores of players.
 */
class GameScore {
    private int dealerWon;
    private int playerWon;
    private int round;

    GameScore() {
        dealerWon = 0;
        playerWon = 0;
        round = 0;
    }

    int getPlayerScore() {
        return playerWon;
    }

    int getDealerScore() {
        return dealerWon;
    }

    int getRound() {
        return round;
    }

    void incrementPlayerScore() {
        playerWon++;
    }

    void incrementDealerScore() {
        dealerWon++;
    }

    void incrementRound() {
        round++;
    }
}
