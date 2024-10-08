package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DivTest {
    @Test
    void testToString() {
        Expression e = new Div(new Number(1), new Number(2));
        assertEquals("(1 / 2)", e.toString());
    }

    @Test
    void copyTest() {
        Expression e = new Div(new Number(1), new Number(2));
        Expression e2 = e.copy();
        assertTrue(e.equals(e2));
    }

    @Test
    void copyTest2() {
        Expression e = new Div(new Number(1), new Variable("hoho"));
        Expression e2 = e.copy();
        assertTrue(e.equals(e2));
    }

    @Test
    void derivTest() {
        Expression e = new Div(new Number(1), new Variable("hoho"));
        Expression e2 = e.derivative("hoho").simplify();
        assertEquals("(1 / (hoho * hoho))", e2.toString());
    }

    @Test
    void derivTest2() {
        Expression e = new Div(new Number(1), new Number(100));
        Expression e2 = e.derivative("hoho").simplify();
        assertEquals("0", e2.toString());
    }

    @Test
    void testToString2() {
        Expression e = new Div(new Variable("hihihaha"), new Number(2));
        assertEquals("(hihihaha / 2)", e.toString());
    }

    @Test
    void divEval1() {
        Expression e = new Div(new Number(1), new Number(2));
        assertEquals(0, e.eval(""));
    }

    @Test
    void divEval2() {
        Expression e = new Div(new Variable("hihi"), new Number(2));
        assertEquals(1, e.eval("hihi = 3"));
    }

    @Test
    void divSimplify1() {
        Expression e = new Div(new Number(0), new Mul(new Number(2), new Variable("haha")));
        Expression simple = e.simplify();
        assertEquals(0, simple.eval());
    }

    @Test
    void divSimplify2() {
        Expression e = new Div(new Sub(new Variable("haha")
                    , new Variable("haha")), new Number(100));
        Expression simple = e.simplify();
        assertEquals(0, simple.eval());
    }
}
