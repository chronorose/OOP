package ru.nsu.tasklist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TaskTest {
    @Test
    void testToString1() {
        Task t = new Task("task", TaskStatus.DONE);
        assertEquals("[x] task", t.toString());
    }

    @Test
    void testToString2() {
        Task t = new Task("task", TaskStatus.NOT_DONE);
        assertEquals("[ ] task", t.toString());
    }
}
