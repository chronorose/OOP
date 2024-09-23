package ru.nsu.players;

import ru.nsu.cards.Card;
import ru.nsu.cards.Deck;

/**
 * Class that represents dealer of blackjack, extendes {@link Player}.
 */
public class Dealer extends Player {
    public static final int DEALER_MAX = 17;

    public Dealer(Deck deck) {
        super(deck);
        getLast().setHidden(true);
    }

    public Card getLast() {
        return hand.get(hand.size() - 1);
    }

    public Card openCard() {
        hand.get(hand.size() - 1).setHidden(false);
        return hand.get(hand.size() - 1);
    }
}
