package ru.nsu.players;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import ru.nsu.cards.Card;
import ru.nsu.cards.Deck;

class DealerTest {
    @Test
    void getLastTest() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        assertTrue(dealer.getLast().getHidden());
    }

    @Test
    void openCardTest() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        Card card = dealer.openCard();
        assertFalse(card.getHidden());
    }

    @Test
    void getLastTest2() {
        Deck deck = new Deck();
        Dealer dealer = new Dealer(deck);
        Card card = dealer.openCard();
        assertEquals(dealer.getLast(), card);
    }
}
