package ru.nsu.table;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import ru.nsu.Text;

class TaskListTest {
    @Test
    void testToString1() {
        Table t = new Table.Builder()
                .addRow(new Text("text1"), new Text("text2"))
                .addRow(new Text("text3"), new Text("text4"))
                .withAlignment(Alignment.LEFT, Alignment.RIGHT)
                .build();
        assertEquals(
                "| text1 | text2 | \n| :--- | ---: | \n| text3 | text4 | \n", t.toString());
    }

    @Test
    void testToString2() {
        Table t = new Table.Builder()
                .addRow(new Text("text1"), new Text("text2"))
                .addRow(new Text("text3"), new Text("text4"))
                .withAlignment(Alignment.CENTER, Alignment.RIGHT)
                .build();
        assertEquals(
                "| text1 | text2 | \n| :---: | ---: | \n| text3 | text4 | \n", t.toString());
    }

    @Test
    void testToString3() {
        Table t = new Table.Builder()
                .addRow(new Text("text1"), new Text("text2"))
                .addRow(new Text("text3"), new Text("text4"))
                .withAlignment(Alignment.CENTER, Alignment.DEFAULT)
                .build();
        assertEquals(
                "| text1 | text2 | \n| :---: | --- | \n| text3 | text4 | \n", t.toString());
    }

    @Test
    void testEquals1() {
        Table t1 = new Table.Builder()
                .build();
        Table t2 = new Table.Builder()
                .build();
        assertEquals(t1, t2);
    }
}
