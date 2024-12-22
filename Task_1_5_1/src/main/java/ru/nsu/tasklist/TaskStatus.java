package ru.nsu.tasklist;

/**
 * enum that represents status of tasks
 * of task list element of markdown.
 */
public enum TaskStatus {
    DONE("[ ]"),
    NOT_DONE("[x]");

    final String statusSymbol;

    TaskStatus(String symbol) {
        statusSymbol = symbol;
    }
}
