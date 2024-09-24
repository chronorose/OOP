package ru.nsu.game;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ru.nsu.cards.Card;
import ru.nsu.cards.CardValue;
import ru.nsu.cards.Deck;

public class GameTest {
    @Test
    void testHandleDealer() {
        Game game = new Game();
        GameState gs = game.state;
        game.io.setState(gs);
        Deck deck = gs.deck;
        int sum = gs.dealer.sum;
        int i = 1;
        while (sum < 17) {
            Card card = deck.viewCard(deck.getSize() - i);
            i++;
            sum += card.getCardV().value;
        }
        game.handleDealer();
        assertEquals(sum, gs.dealer.sum);
    }

    @Test
    void testHandlePlayer() {
        Game game = new Game();
        GameState gs = game.state;
        game.io.setState(gs);
        game.state.player.sum = 21;
        game.state.dealer.sum = 0;
        Result res = game.handlePlayer();
        assertEquals(res, Result.PlayerWon);
    }

    @Test
    void testCheckEndgame() {
        Game game = new Game();
        GameState gs = game.state;
        game.io.setState(gs);
        game.state.player.sum = 21;
        game.state.dealer.sum = 21;
        gs.result = Result.NotDecided;
        Result res = game.checkEndgame();
        assertEquals(res, Result.Draw);
    }

    @Test
    void testCheckState() {
        Game game = new Game();
        GameState gs = game.state;
        game.io.setState(gs);
        game.state.player.sum = 21;
        game.state.dealer.sum = 18;
        Result res = game.checkState();
        assertEquals(res, Result.PlayerWon);
    }

    @Test
    void testAddCounts() {
        Game game = new Game();
        GameState gs = game.state;
        game.io.setState(gs);
        game.state.player.sum = 21;
        game.state.dealer.sum = 18;
        int score = game.score.getPlayerScore();
        game.addCounts();
        assertEquals(score + 1, game.score.getPlayerScore());
    }
}
