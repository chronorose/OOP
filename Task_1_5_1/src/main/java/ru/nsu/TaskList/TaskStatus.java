package ru.nsu.TaskList;

public enum TaskStatus {
  DONE("[ ]"),
  NOT_DONE("[x]");

  final String statusSymbol;

  TaskStatus(String symbol) {
    statusSymbol = symbol;
  }
}
