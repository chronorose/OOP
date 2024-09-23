package ru.nsu.cards;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DeckTest {
    @Test
    void getCardTest() {
        Deck deck = new Deck();
        Card lastCard = deck.cards.get(deck.cards.size() - 1);
        assertEquals(lastCard, deck.getCard());
    }
}
