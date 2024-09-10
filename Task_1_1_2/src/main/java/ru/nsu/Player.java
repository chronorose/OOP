package ru.nsu;

import java.util.ArrayList;

class Player {
    protected ArrayList<Card> hand;

    int getSum() {
        int sum = 0;
        int aces = 0;
        for (Card card: hand) {
            sum += card.getCV().value; 
            if (card.getCV() == CardValue.Ace) {
                aces++;
            }
        }
        if (sum > 21) {
            sum -= aces * 10;
        }
        return sum;
    }

    Player(Deck deck) {
        this.hand = new ArrayList<>();
        addCard(deck.getCard());
        addCard(deck.getCard());
    }

    void addCard(Card card) {
        hand.add(card);
    }

    @Override
    public String toString() {
        return hand.toString();
    }
}
