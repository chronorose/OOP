package ru.nsu.players;

import static org.junit.jupiter.api.Assertions.assertEquals;

import ru.nsu.cards.*;
import org.junit.jupiter.api.Test;

class PlayerTest {
    @Test
    void testSum() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        for (int i = 0; i < 30; i++) {
            player.addCard(deck.getCard());
        }
        int prevSum = player.sum;
        Card card = new Card(Kind.Clubs, CardValue.Ace);
        player.addCard(card);
        assertEquals(prevSum + 1, player.sum);
    }

    @Test
    void testSum2() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        for (int i = 0; i < 30; i++) {
            player.addCard(deck.getCard());
        }
        int prevSum = player.sum;
        Card card = new Card(Kind.Clubs, CardValue.Ten);
        player.addCard(card);
        assertEquals(prevSum + 10, player.sum);
    }

    @Test
    void testSum3() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        for (int i = 0; i < 30; i++) {
            player.addCard(deck.getCard());
        }
        int prevSum = player.sum;
        Card card = new Card(Kind.Clubs, CardValue.Nine);
        player.addCard(card);
        assertEquals(prevSum + 9, player.sum);
    }

    @Test
    void testSum4() {
        Deck deck = new Deck();
        Player player = new Player(deck);
        for (int i = 0; i < 30; i++) {
            player.addCard(deck.getCard());
        }
        int prevSum = player.sum;
        Card card = new Card(Kind.Clubs, CardValue.Eight);
        player.addCard(card);
        assertEquals(prevSum + 8, player.sum);
    }
}

