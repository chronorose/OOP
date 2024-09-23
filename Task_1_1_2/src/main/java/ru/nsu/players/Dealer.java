package ru.nsu.players;

import ru.nsu.cards.Deck;
import ru.nsu.cards.Card;

public class Dealer extends Player {
    public final static int DEALER_MAX = 17;

    public Dealer(Deck deck) {
        super(deck);
        hand.getLast().setHidden(true);
    }

    public Card getLast() {
        return hand.get(hand.size() - 1);
    }

    public Card openCard() {
        hand.get(hand.size() - 1).setHidden(false);
        return hand.get(hand.size() - 1);
    }
}
