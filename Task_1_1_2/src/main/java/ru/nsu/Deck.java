package ru.nsu;

import java.util.Random;

public class Deck {
    Card[] cards; 
    int leftCards;
    Random random;

    Deck() {
        cards = new Card[52];
        random = new Random();
        leftCards = 0;
        for (Kind kind: Kind.values()) {
            for (CardValue cv: CardValue.values()) {
                cards[leftCards++] = new Card(kind, cv);
            }
        }
    }
    Card getCard() {
        if (leftCards <= 0) {
            return null;
        }
        int index = getUnusedCard();
        cards[index].setUsed(true);
        leftCards--; 
        return cards[index];
    }
    private int getUnusedCard() {
        int index = random.nextInt(52);
        if (cards[index].getUsed()) {
            index = getUnusedCard();
        }
        return index;
    }
}
