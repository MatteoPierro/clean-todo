package io.vocidelcodice.todo.addtodo.usecase;

public class AddTodoOutputData {
    public final Integer id;
    public final Priority priority;
    public final String message;

    public AddTodoOutputData(Integer id, Priority priority, String message) {
        this.id = id;
        this.priority = priority;
        this.message = message;
    }

    public enum Priority {
        HIGH
    }
}
