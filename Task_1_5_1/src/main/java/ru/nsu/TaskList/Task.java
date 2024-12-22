package ru.nsu.TaskList;

import ru.nsu.Text;

class Task extends Text {
    private TaskStatus status;

    @Override
    public String toString() {
        return status.statusSymbol + " " + text;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Task otherTask = (Task) obj;
        return text.equals(otherTask.text) && status.equals(otherTask.status);
    }

    Task(String task, TaskStatus status) {
        super(task);
        this.status = status;
    }
}
