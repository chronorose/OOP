package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class AddTest {
    @Test
    void testToString() {
        Expression e = new Add(new Number(1), new Number(2));
        assertEquals("(1 + 2)", e.toString());
    }

    @Test
    void testToString2() {
        Expression e = new Add(new Variable("hihihaha"), new Number(2));
        assertEquals("(hihihaha + 2)", e.toString());
    }

    @Test
    void addEval1() {
        Expression e = new Add(new Number(1), new Number(2));
        assertEquals(3, e.eval(""));
    }

    @Test
    void addEval2() {
        Expression e = new Add(new Variable("hihi"), new Number(2));
        assertEquals(5, e.eval("hihi = 3"));
    }
}
