package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class SubTest {
    @Test
    void testToString() {
        Expression e = new Sub(new Number(1), new Number(2));
        assertEquals("(1 - 2)", e.toString());
    }

    @Test
    void copyTest() {
        Expression e = new Sub(new Number(1), new Number(2));
        Expression e2 = e.copy();
        assertTrue(e.equals(e2));
    }

    @Test
    void copyTest2() {
        Expression e = new Sub(new Number(1), new Variable("hoho"));
        Expression e2 = e.copy();
        assertTrue(e.equals(e2));
    }


    @Test
    void testToString2() {
        Expression e = new Sub(new Variable("hihihaha"), new Number(2));
        assertEquals("(hihihaha - 2)", e.toString());
    }

    @Test
    void subEval1() {
        Expression e = new Sub(new Number(1), new Number(2));
        assertEquals(-1, e.eval(""));
    }

    @Test
    void subEval2() {
        Expression e = new Sub(new Variable("hihi"), new Number(2));
        assertEquals(1, e.eval("hihi = 3"));
    }

    @Test
    void subSimplify1() {
        Expression e = new Sub(new Number(3), new Mul(new Number(0), new Variable("haha")));
        Expression simple = e.simplify();
        assertEquals(3, simple.eval());
    }

    @Test
    void subSimplify2() {
        Expression e = new Sub(new Number(3), new Sub(new Variable("haha"), new Variable("haha")));
        Expression simple = e.simplify();
        assertEquals(3, simple.eval());
    }

    @Test
    void subSimplify3() {
        Expression e = new Sub(new Sub(new Variable("hoh"), new Variable("hoh")),
                new Sub(new Variable("haha"), new Variable("haha")));
        Expression simple = e.simplify();
        assertEquals(0, simple.eval());
    }
}
