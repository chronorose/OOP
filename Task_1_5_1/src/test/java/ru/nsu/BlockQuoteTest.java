package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class BlockQuoteTest {
    @Test
    void testToString1() {
        BlockQuote bq = new BlockQuote("hehe");
        assertEquals("> hehe  ", bq.toString());
    }

    @Test
    void testToString2() {
        BlockQuote bq = new BlockQuote("hehe\nvery\ninteresting");
        assertEquals("> hehe  \nvery  \ninteresting  ", bq.toString());
    }

    @Test
    void testEquals1() {
        BlockQuote bq = new BlockQuote(new Text("haha").toString());
        BlockQuote bq2 = new BlockQuote(new Text("haha").toString());
        assertEquals(bq, bq2);
    }

    @Test
    void testEquals2() {
        BlockQuote bq = new BlockQuote(new Text("haha").toString());
        BlockQuote bq2 = new BlockQuote(new Text.Bold("haha").toString());
        assertNotEquals(bq, bq2);
    }

    @Test
    void testEquals3() {
        BlockQuote bq = new BlockQuote(new Text.Italic("haha").toString());
        BlockQuote bq2 = new BlockQuote(new Text.Bold("haha").toString());
        assertNotEquals(bq, bq2);
    }
}
