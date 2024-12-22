package ru.nsu.list;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import ru.nsu.Text;

class ListTest {
    @Test
    void testToString1() {
        List list = new List.Builder()
                .addLine(new Text("hoho"))
                .withListType(ListType.UNORDERED)
                .build();
        assertEquals("- hoho\n", list.toString());
    }

    @Test
    void testToString2() {
        List list = new List.Builder()
                .addLine(new Text("hoho"))
                .addLine(new Text("hihi"))
                .withListType(ListType.UNORDERED)
                .build();
        assertEquals("- hoho\n- hihi\n", list.toString());
    }

    @Test
    void testToString3() {
        List list = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .withListType(ListType.UNORDERED)
                .build();
        assertEquals("- hoho\n    - hihi\n", list.toString());
    }

    @Test
    void testToString4() {
        List list = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .withListType(ListType.ORDERED)
                .build();
        assertEquals("1. hoho\n    2. hihi\n", list.toString());
    }

    @Test
    void testToString5() {
        List list = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.ORDERED)
                .build();
        assertEquals("1. hoho\n    2. hihi\n3. hoho\n", list.toString());
    }

    @Test
    void testEquals1() {
        List l1 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.ORDERED)
                .build();
        List l2 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.ORDERED)
                .build();
        assertEquals(l1, l2);
    }

    @Test
    void testEquals2() {
        List l1 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.UNORDERED)
                .build();
        List l2 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.ORDERED)
                .build();
        assertNotEquals(l1, l2);
    }

    @Test
    void testEquals3() {
        List l1 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.UNORDERED)
                .build();
        List l2 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.ORDERED)
                .build();
        assertNotEquals(l1, l2);
    }

    @Test
    void testEquals4() {
        List l1 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hohi"))
                .withListType(ListType.ORDERED)
                .build();
        List l2 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.ORDERED)
                .build();
        assertNotEquals(l1, l2);
    }

    @Test
    void testEquals5() {
        List l1 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 3)
                .addLine(new Text("hoho"))
                .withListType(ListType.ORDERED)
                .build();
        List l2 = new List.Builder()
                .addLine(new Text("hoho"))
                .addLineIdented(new Text("hihi"), 4)
                .addLine(new Text("hoho"))
                .withListType(ListType.ORDERED)
                .build();
        assertNotEquals(l1, l2);
    }
}
