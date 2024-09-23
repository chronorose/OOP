package ru.nsu.cards;

import java.util.Random;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;

public class Deck {
    ArrayList<Card> cards;
    int leftCards;
    Random random;

    public Deck() {
        cards = new ArrayList<Card>(52);
        random = new Random();
        leftCards = 0;
        for (Kind kind : Kind.values()) {
            for (CardValue cv : CardValue.values()) {
                cards.add(leftCards++, new Card(kind, cv));
            }
        }
        Collections.shuffle(cards);
    }

    public Card getCard() {
        if (leftCards <= 0) {
            throw new NoSuchElementException();
        }
        return cards.removeLast();
    }
}
