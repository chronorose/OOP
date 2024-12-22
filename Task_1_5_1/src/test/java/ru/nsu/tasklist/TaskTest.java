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

    @Test
    void testEquality1() {
        Task t1 = new Task("hehe", TaskStatus.NOT_DONE);
        Task t2 = new Task("hehe", TaskStatus.NOT_DONE);
        assertEquals(t1, t2);
    }

    @Test
    void testEquality2() {
        Task t1 = new Task("hehe", TaskStatus.DONE);
        Task t2 = new Task("hehe", TaskStatus.NOT_DONE);
        assertNotEquals(t1, t2);
    }

    @Test
    void testEquality3() {
        Task t1 = new Task("hehehaha", TaskStatus.DONE);
        Task t2 = new Task("hehe", TaskStatus.NOT_DONE);
        assertNotEquals(t1, t2);
    }

    @Test
    void testEquality4() {
        Task t1 = new Task("hehehaha", TaskStatus.NOT_DONE);
        Task t2 = new Task("hehe", TaskStatus.NOT_DONE);
        assertNotEquals(t1, t2);
    }
}
