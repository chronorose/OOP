package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class AddTest {
    @Test
    void testToString() {
        Expression e = new Add(new Number(1), new Number(2));
        assertEquals("(1 + 2)", e.toString());
    }

    @Test
    void copyTest() {
        Expression e = new Add(new Number(1), new Number(2));
        Expression e2 = e.copy();
        assertTrue(e.equals(e2));
    }

    @Test
    void copyTest2() {
        Expression e = new Add(new Number(1), new Variable("hoho"));
        Expression e2 = e.copy();
        assertTrue(e.equals(e2));
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

    @Test
    void addSimplify1() {
        Expression e = new Add(new Number(3), new Mul(new Number(0), new Variable("haha")));
        Expression simple = e.simplify();
        assertEquals(3, simple.eval());
    }

    @Test
    void addSimplify2() {
        Expression e = new Add(new Number(3), new Sub(new Variable("haha"), new Variable("haha")));
        Expression simple = e.simplify();
        assertEquals(3, simple.eval());
    }
}
