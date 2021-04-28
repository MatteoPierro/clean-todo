package io.vocidelcodice.todo.addtodo.usecase;

public class AddTodoOutputData {
    public final Integer id;
    public final Priority priority;

    public AddTodoOutputData(Integer id, Priority priority) {
        this.id = id;
        this.priority = priority;
    }

    public enum Priority {
        HIGH
    }
}
