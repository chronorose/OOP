package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class HeadingTest {
    @Test
    void testToString1() {
        Heading heading = new Heading("hoho!", 2);
        assertEquals("## hoho!", heading.toString());
    }

    @Test
    void testToString2() {
        Heading heading = new Heading("hoho!", 0);
        assertEquals(" hoho!", heading.toString());
    }

    @Test
    void testToString3() {
        Heading heading = new Heading("hoho!", 4);
        assertEquals("#### hoho!", heading.toString());
    }

    @Test
    void testEquals1() {
        Heading h1 = new Heading("hoho", 4);
        Heading h2 = new Heading("hoho", 4);
        assertEquals(h1, h2);
    }

    @Test
    void testEquals2() {
        Heading h1 = new Heading("hoho", 0);
        Heading h2 = new Heading("hoho", 0);
        assertEquals(h1, h2);
    }

    @Test
    void testEquals3() {
        Heading h1 = new Heading("hoho", 3);
        Heading h2 = new Heading("hoho", 3);
        assertEquals(h1, h2);
    }

    @Test
    void testEquals4() {
        Heading h1 = new Heading("hoho", 10);
        Heading h2 = new Heading("hoho", 10);
        assertEquals(h1, h2);
    }

    @Test
    void testEquals5() {
        Heading h1 = new Heading("hoho", 0);
        Heading h2 = new Heading("hoho", 10);
        assertNotEquals(h1, h2);
    }

    @Test
    void testEquals6() {
        Heading h1 = new Heading("hoho", 5);
        Heading h2 = new Heading("hoho", 10);
        assertNotEquals(h1, h2);
    }

    @Test
    void testEquals7() {
        Heading h1 = new Heading("hoho", 5);
        Heading h2 = new Heading("hoho", 7);
        assertNotEquals(h1, h2);
    }

    @Test
    void testEquals8() {
        Heading h1 = new Heading("hihi", 5);
        Heading h2 = new Heading("hoho", 5);
        assertNotEquals(h1, h2);
    }
}
