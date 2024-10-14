package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class MulTest {
    @Test
    void testToString() {
        Expression e = new Mul(new Number(1), new Number(2));
        assertEquals("(1 * 2)", e.toString());
    }

    @Test
    void testToString2() {
        Expression e = new Mul(new Variable("hihihaha"), new Number(2));
        assertEquals("(hihihaha * 2)", e.toString());
    }

    @Test
    void mulEval1() {
        Expression e = new Mul(new Number(1), new Number(2));
        assertEquals(2, e.eval(""));
    }

    @Test
    void mulEval2() {
        Expression e = new Mul(new Variable("hihi"), new Number(2));
        assertEquals(6, e.eval("hihi = 3"));
    }

    @Test
    void mulSimplify1() {
        Expression e = new Mul(new Number(3), new Mul(new Number(0), new Variable("haha")));
        Expression simple = e.simplify();
        assertEquals(0, simple.eval());
    }

    @Test
    void mulSimplify2() {
        Expression e = new Mul(new Number(3), new Sub(new Variable("haha"), new Variable("haha")));
        Expression simple = e.simplify();
        assertEquals(0, simple.eval());
    }

    @Test
    void derivTest() {
        Expression e = new Mul(new Variable("x"), new Number(3));
        Expression d = e.derivative("x").simplify();
        assertEquals("3", d.toString());
    }

    @Test
    void derivTest2() {
        Expression e = new Mul(new Mul(new Variable("x"), new Number(20)), new Number(3));
        Expression d = e.derivative("x").simplify();
        assertEquals("60", d.toString());
    }

    @Test
    void mulSimplify3() {
        Expression e = new Mul(new Number(1), new Variable("haha"));
        Expression simple = e.simplify();
        assertEquals("haha", simple.toString());
    }
    
    @Test
    void copyTest() {
        Expression e = new Mul(new Number(1), new Number(2));
        Expression e2 = e.copy();
        assertTrue(e.equals(e2));
    }

    @Test
    void copyTest2() {
        Expression e = new Mul(new Number(1), new Variable("hoho"));
        Expression e2 = e.copy();
        assertTrue(e.equals(e2));
    }
}
