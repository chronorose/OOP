package ru.nsu.TaskList;

import java.util.ArrayList;

public class TaskList {
  private ArrayList<Task> tasks;

  private TaskList() {
    tasks = new ArrayList<>();
  }

  @Override
  public String toString() {
    return tasks
        .stream()
        .map(x -> x.toString())
        .reduce((acc, line) -> acc + line).get();
  }

  private TaskList(Builder builder) {
    tasks = new ArrayList<>(builder.taskList.tasks);
  }

  public static class Builder {
    TaskList taskList;

    public Builder() {
      taskList = new TaskList();
    }

    public Builder addTask(String task) {
      taskList.tasks.add(new Task(task, TaskStatus.NOT_DONE));
      return this;
    }

    public Builder addDoneTask(String task) {
      taskList.tasks.add(new Task(task, TaskStatus.DONE));
      return this;
    }

    public Builder doneTask(int index) {
      taskList.tasks.get(index).status = TaskStatus.DONE;
      return this;
    }

    public TaskList build() {
      return new TaskList(this);
    }
  }
}
