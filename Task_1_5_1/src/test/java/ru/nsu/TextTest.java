package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TextTest {

    @Test
    void testToString1() {
        assertEquals("hoho", new Text("hoho").toString());
    }

    @Test
    void testToString2() {
        assertEquals("**hoho**", new Text.Bold("hoho").toString());
    }

    @Test
    void testToString3() {
        assertEquals("*hoho*", new Text.Italic("hoho").toString());
    }

    @Test
    void testToString4() {
        assertEquals("`hoho`", new Text.Code("hoho").toString());
    }

    @Test
    void testToString5() {
        assertEquals("~~hoho~~", new Text.Strikethrough("hoho").toString());
    }

    @Test
    void testToString6() {
        assertEquals("==hoho==", new Text.Highlight("hoho").toString());
    }

    void testToString7() {
        assertEquals("hoho\nhihi", new Text("hoho\nhihi").toString());
    }

    @Test
    void testToString8() {
        assertEquals("**hoho\nhihi**", new Text.Bold("hoho\nhihi").toString());
    }

    @Test
    void testToString9() {
        assertEquals("*hoho\nhihi*", new Text.Italic("hoho\nhihi").toString());
    }

    @Test
    void testToString10() {
        assertEquals("`hoho\nhihi`", new Text.Code("hoho\nhihi").toString());
    }

    @Test
    void testToString11() {
        assertEquals("~~hoho\nhihi~~", new Text.Strikethrough("hoho\nhihi").toString());
    }

    @Test
    void testToString12() {
        assertEquals("==hoho\nhihi==", new Text.Highlight("hoho\nhihi").toString());
    }

    @Test
    void testEquals1() {
        assertEquals(new Text.Bold("hoho"), new Text.Bold("hoho"));
    }

    @Test
    void testEquals2() {
        assertNotEquals(new Text.Bold("hoho"), new Text.Bold("hihi"));
    }

    @Test
    void testEquals3() {
        assertNotEquals(new Text.Italic("hoho"), new Text.Italic("hihi"));
    }

    @Test
    void testEquals4() {
        assertNotEquals(new Text.Code("hoho"), new Text.Code("hihi"));
    }

    @Test
    void testEquals6() {
        assertNotEquals(new Text.Strikethrough("hoho"), new Text.Strikethrough("hihi"));
    }

    @Test
    void testEquals7() {
        assertNotEquals(new Text.Highlight("hoho"), new Text.Highlight("hihi"));
    }

    @Test
    void testEquals8() {
        assertEquals(new Text.Italic("hoho"), new Text.Italic("hoho"));
    }

    @Test
    void testEquals10() {
        assertEquals(new Text.Code("hoho"), new Text.Code("hoho"));
    }

    @Test
    void testEquals11() {
        assertEquals(new Text.Strikethrough("hoho"), new Text.Strikethrough("hoho"));
    }

    @Test
    void testEquals12() {
        assertEquals(new Text.Highlight("hoho"), new Text.Highlight("hoho"));
    }

    @Test
    void testEquals13() {
        assertNotEquals(new Text("hoho"), new Text.Highlight("hoho"));
    }

    @Test
    void testEquals14() {
        assertNotEquals(new Text("hoho"), new Text.Code("hoho"));
    }

    @Test
    void testEquals15() {
        assertNotEquals(new Text("hoho"), new Text.Code("hoho"));
    }

    @Test
    void testEquals16() {
        assertNotEquals(new Text("hoho"), new Text.Strikethrough("hoho"));
    }

    @Test
    void testEquals17() {
        assertNotEquals(new Text("hoho"), new Text.Bold("hoho"));
    }

    @Test
    void testEquals18() {
        assertNotEquals(new Text.Bold("hoho"), new Text("hoho"));
    }

    @Test
    void testEquals19() {
        assertNotEquals(new Text.Bold("hoho"), new Text.Strikethrough("hoho"));
    }

    @Test
    void testEquals20() {
        assertNotEquals(new Text.Bold("hoho"), new Text.Highlight("hoho"));
    }

    @Test
    void testEquals21() {
        assertNotEquals(new Text.Bold("hoho"), new Text.Italic("hoho"));
    }

    @Test
    void testEquals22() {
        assertNotEquals(new Text.Bold("hoho"), new Text.Code("hoho"));
    }
}
