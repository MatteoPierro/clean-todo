package io.vocidelcodice.todo.addtodo.usecase;

public interface AddTodoOutputBoundary {
    void addTodoSucceeded(AddTodoOutputData addTodoOutputData);

    void addTodoFailed(AddTodoViolations violation);
}
