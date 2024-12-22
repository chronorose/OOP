package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class CodeBlockTest {
    @Test
    void testToString1() {
        CodeBlock bq = new CodeBlock("hehe");
        assertEquals("```\nhehe\n```", bq.toString());
    }

    @Test
    void testToString2() {
        CodeBlock bq = new CodeBlock("hehe\nhoho");
        assertEquals("```\nhehe\nhoho\n```", bq.toString());
    }

    @Test
    void testEquals1() {
        CodeBlock bq = new CodeBlock(new Text("haha").toString());
        CodeBlock bq2 = new CodeBlock(new Text("haha").toString());
        assertEquals(bq, bq2);
    }

    @Test
    void testEquals2() {
        CodeBlock bq = new CodeBlock(new Text.Bold("haha").toString());
        CodeBlock bq2 = new CodeBlock(new Text("haha").toString());
        assertNotEquals(bq, bq2);
    }

    @Test
    void testEquals3() {
        CodeBlock bq = new CodeBlock(new Text.Bold("haha").toString());
        CodeBlock bq2 = new CodeBlock(new Text.Italic("haha").toString());
        assertNotEquals(bq, bq2);
    }

    @Test
    void testEquals4() {
        CodeBlock bq = new CodeBlock(new Text.Code("haha").toString());
        CodeBlock bq2 = new CodeBlock(new Text.Italic("haha").toString());
        assertNotEquals(bq, bq2);
    }
}
