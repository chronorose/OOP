package ru.nsu.tasklist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class TaskListTest {
    @Test
    void testToString1() {
        TaskList t = new TaskList.Builder()
                .addTask("task1")
                .addDoneTask("task2")
                .build();
        assertEquals("- [ ] task1\n- [x] task2\n", t.toString());
    }

    @Test
    void testToString2() {
        TaskList t = new TaskList.Builder()
                .addTask("task1")
                .addDoneTask("task3")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        assertEquals(
                "- [ ] task1\n- [x] task3\n- [x] task2\n- [ ] task4\n",
                t.toString());
    }

    @Test
    void testEquals1() {
        TaskList t1 = new TaskList.Builder()
                .addTask("task1")
                .addDoneTask("task3")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        TaskList t2 = new TaskList.Builder()
                .addTask("task1")
                .addDoneTask("task3")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        assertEquals(t1, t2);
    }

    @Test
    void testEquals2() {
        TaskList t1 = new TaskList.Builder()
                .addTask("task4")
                .addDoneTask("task3")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        TaskList t2 = new TaskList.Builder()
                .addTask("task1")
                .addDoneTask("task3")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        assertNotEquals(t1, t2);
    }

    @Test
    void testEquals4() {
        TaskList t1 = new TaskList.Builder()
                .addTask("task4")
                .addDoneTask("task3")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        TaskList t2 = new TaskList.Builder()
                .addTask("task1")
                .addDoneTask("task5")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        assertNotEquals(t1, t2);
    }

    @Test
    void testEquals5() {
        TaskList t1 = new TaskList.Builder()
                .addTask("task4")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        TaskList t2 = new TaskList.Builder()
                .addTask("task1")
                .addDoneTask("task5")
                .addDoneTask("task2")
                .addTask("task4")
                .build();
        assertNotEquals(t1, t2);
    }
}
