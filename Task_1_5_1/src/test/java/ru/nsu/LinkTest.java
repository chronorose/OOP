package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class LinkTest {
    @Test
    void testToString1() {
        Link im = new Link.Builder()
                .withLink("link")
                .withAltText("altText")
                .build();
        assertEquals("[altText](link)", im.toString());
    }

    @Test
    void testToString2() {
        Link im = new Link.Builder()
                .withLink(new Text.Bold("hihi\nhoho").toString())
                .withAltText(new Text.Italic("haha!!\nHoho!").toString())
                .build();
        assertEquals("[*haha!!\nHoho!*](**hihi\nhoho**)", im.toString());
    }

    @Test
    void testEquals1() {
        Link im = new Link.Builder()
                .withLink(new Text.Bold("hihi\nhoho").toString())
                .withAltText(new Text.Italic("haha!!\nHoho!").toString())
                .build();
        Link im2 = new Link.Builder()
                .withLink(new Text.Bold("hihi\nhoho").toString())
                .withAltText(new Text.Italic("haha!!\nHoho!").toString())
                .build();
        assertEquals(im, im2);
    }

    @Test
    void testEquals2() {
        Link im = new Link.Builder()
                .withLink(new Text.Bold("hoho\nhoho").toString())
                .withAltText(new Text.Italic("haha!!\nHoho!").toString())
                .build();
        Link im2 = new Link.Builder()
                .withLink(new Text.Bold("hihi\nhoho").toString())
                .withAltText(new Text.Italic("haha!!\nHoho!").toString())
                .build();
        assertNotEquals(im, im2);
    }

    @Test
    void testEquals3() {
        Link im = new Link.Builder()
                .withLink(new Text.Bold("hoho\nhoho").toString())
                .withAltText(new Text.Italic("haha!!\nHoho!").toString())
                .build();
        Link im2 = new Link.Builder()
                .withLink(new Text.Bold("hihi\nhoho").toString())
                .withAltText(new Text.Code("haha!!\nHoho!").toString())
                .build();
        assertNotEquals(im, im2);
    }
}
