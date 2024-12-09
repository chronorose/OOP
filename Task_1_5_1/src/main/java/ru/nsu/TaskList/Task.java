package ru.nsu.TaskList;

class Task {
  String task;
  TaskStatus status;

  @Override
  public String toString() {
    return "- " + status.statusSymbol + task + "\n";
  }

  Task(String task, TaskStatus status) {
    this.task = task;
    this.status = status;
  }
}
