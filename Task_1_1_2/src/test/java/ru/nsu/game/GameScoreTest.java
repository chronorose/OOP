package ru.nsu.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class GameScoreTest {
    @Test
    void testRound1() {
        GameScore score = new GameScore();
        int prevRound = score.getRound();
        score.incrementRound();
        assertEquals(prevRound + 1, score.getRound());
    }

    @Test
    void testRound2() {
        GameScore score = new GameScore();
        int prevRound = score.getRound();
        score.incrementRound();
        score.incrementRound();
        assertEquals(prevRound + 2, score.getRound());
    }

    @Test
    void testPlayerScore1() {
        GameScore score = new GameScore();
        int prevScore = score.getPlayerScore();
        score.incrementPScore();
        assertEquals(prevScore + 1, score.getPlayerScore());

    }

    @Test
    void testPlayerScore2() {
        GameScore score = new GameScore();
        int prevScore = score.getPlayerScore();
        score.incrementPScore();
        score.incrementPScore();
        assertEquals(prevScore + 2, score.getPlayerScore());

    }

    @Test
    void testDealerScore1() {
        GameScore score = new GameScore();
        int prevScore = score.getDealerScore();
        score.incrementDScore();
        assertEquals(prevScore + 1, score.getDealerScore());

    }

    @Test
    void testDealerScore2() {
        GameScore score = new GameScore();
        int prevScore = score.getDealerScore();
        score.incrementDScore();
        score.incrementDScore();
        assertEquals(prevScore + 2, score.getDealerScore());

    }
}
