package ru.nsu.players;

import java.util.ArrayList;
import ru.nsu.cards.Card;
import ru.nsu.cards.CardValue;
import ru.nsu.cards.Deck;

/**
 * Class that represents player.
 */
public class Player {
    public int sum = 0;
    protected ArrayList<Card> hand;
    private int aces = 0;

    public Player(Deck deck) {
        this.hand = new ArrayList<>();
        addCard(deck.getCard());
        addCard(deck.getCard());
    }

    private void normalize() {
        for (Card card : hand) {
            if (card.getCardV() == CardValue.Ace) {
                card.setNormalized();
            }
        }
    }

    private int setSum(Card card) {
        sum += card.getCardV().value;
        if (card.getCardV() == CardValue.Ace) {
            aces++;
        }
        if (sum > 21) {
            sum -= aces * 10;
            aces = 0;
            normalize();
        }
        return sum;
    }

    public void addCard(Card card) {
        hand.add(card);
        setSum(card);
    }

    @Override
    public String toString() {
        return hand.toString();
    }
}
