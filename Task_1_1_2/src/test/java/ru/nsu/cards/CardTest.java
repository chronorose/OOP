package ru.nsu.cards;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {
    @Test
    void testNormalized() {
        Card card = new Card(Kind.Clubs, CardValue.Ace);
        card.setNormalized();
        assertTrue(card.normalized);
    }

    @Test
    void testNormalized2() {
        Card card = new Card(Kind.Clubs, CardValue.Ace);
        assertFalse(card.normalized);
    }

    @Test
    void testCV1() {
        Card card = new Card(Kind.Clubs, CardValue.Ace);
        assertEquals(card.getCV(), CardValue.Ace);
    }

    @Test
    void testCV2() {
        Card card = new Card(Kind.Clubs, CardValue.Six);
        assertEquals(card.getCV(), CardValue.Six);
    }

    @Test
    void testCV3() {
        Card card = new Card(Kind.Clubs, CardValue.Seven);
        assertEquals(card.getCV(), CardValue.Seven);
    }

    @Test
    void testCV4() {
        Card card = new Card(Kind.Clubs, CardValue.Eight);
        assertEquals(card.getCV(), CardValue.Eight);
    }

    @Test
    void testCV5() {
        Card card = new Card(Kind.Clubs, CardValue.Nine);
        assertEquals(card.getCV(), CardValue.Nine);
    }

    @Test
    void testTS1() {
        Card card = new Card(Kind.Clubs, CardValue.Nine);
        assertEquals(CardValue.Nine.name + " " + Kind.Clubs.name + " (" + CardValue.Nine.value + ")", card.toString());
    }

    @Test
    void testTS2() {
        Card card = new Card(Kind.Clubs, CardValue.Ace);
        card.setNormalized();
        assertEquals(CardValue.Ace.name + " " + Kind.Clubs.name + " (1)", card.toString());
    }

    @Test
    void testGKind1() {
        Card card = new Card(Kind.Clubs, CardValue.Ace);
        assertEquals(Kind.Clubs, card.getKind());
    }

    @Test
    void testGKind2() {
        Card card = new Card(Kind.Diamonds, CardValue.Ace);
        assertEquals(Kind.Diamonds, card.getKind());
    }

    @Test
    void testHidden1() {
        Card card = new Card(Kind.Clubs, CardValue.Nine);
        assertFalse(card.getHidden());
    }

    @Test
    void testHidden2() {
        Card card = new Card(Kind.Clubs, CardValue.Nine);
        card.setHidden(true);
        assertTrue(card.getHidden());
    }
}
