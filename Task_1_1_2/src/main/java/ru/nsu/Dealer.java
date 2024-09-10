package ru.nsu;

class Dealer extends Player {
    final static int DEALER_MAX = 17;
    Dealer(Deck deck) {
        super(deck);
        hand.getLast().setHidden(true);
    }
    void openCard() {
        hand.getLast().setHidden(false);
    }
}
