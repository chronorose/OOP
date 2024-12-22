package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class UtilTest {
    @Test
    void testPrefix() {
        String hehe = "haha\nhehe";
        assertEquals("  haha\n  hehe", Util.appendPrefix("  ", hehe));

    }

    @Test
    void testPostfix() {
        String hehe = "haha\nhehe";
        assertEquals("haha  \nhehe  ", Util.appendPostfix("  ", hehe));

    }
}
