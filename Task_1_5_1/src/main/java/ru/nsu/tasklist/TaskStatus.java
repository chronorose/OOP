package ru.nsu.tasklist;

/**
 * enum that represents status of tasks
 * of task list element of markdown.
 */
public enum TaskStatus {
    DONE("[x]"),
    NOT_DONE("[ ]");

    final String statusSymbol;

    TaskStatus(String symbol) {
        statusSymbol = symbol;
    }
}
