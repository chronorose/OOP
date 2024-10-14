package ru.nsu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ParserTest {
    @Test
    void parserTest() {
        String str = "1 * 2 + 3";
        Expression e = Parser.parse(str);
        assertEquals(5, e.eval());
    }

    @Test
    void parserTest2() {
        String str = "1 * hoho + 3";
        Expression e = Parser.parse(str);
        assertEquals(13, e.eval("hoho = 10"));
    }

    @Test
    void parserTest3() {
        String str = "hihi * hoho + 3";
        Expression e = Parser.parse(str);
        assertEquals(1003, e.eval("hoho = 10; hihi = 100"));
    }

    @Test
    void parserTest4() {
        String str = "hihi * hoho + 3 * 16";
        Expression e = Parser.parse(str);
        assertEquals(1048, e.eval("hoho = 10; hihi = 100"));
    }
}
