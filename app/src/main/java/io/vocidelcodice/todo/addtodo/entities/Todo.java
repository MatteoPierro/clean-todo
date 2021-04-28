package io.vocidelcodice.todo.addtodo.entities;

public class Todo {
    private final Integer id;
    private final Priority priority;
    private final String message;

    public Todo(Integer id, Priority priority, String message) {
        this.id = id;
        this.priority = priority;
        this.message = message;
    }

    public Integer id() {
        return id;
    }

    public Priority priority() {
        return priority;
    }
}
