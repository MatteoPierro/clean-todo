package io.vocidelcodice.todo.addtodo.usecase;

import io.vocidelcodice.todo.addtodo.entities.Priority;
import io.vocidelcodice.todo.addtodo.entities.Todo;

public class AddTodoUseCase implements AddTodoInputBoundary {
    private AddTodoDataAccessInterface dataAccessInterface;
    private AddTodoOutputBoundary outputBoundary;

    public AddTodoUseCase(AddTodoDataAccessInterface dataAccessInterface, AddTodoOutputBoundary outputBoundary) {
        this.dataAccessInterface = dataAccessInterface;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void addTodo(AddTodoInputData addTodoInputData) {
        Todo todo = new Todo(123, Priority.HIGH, addTodoInputData.message);
        dataAccessInterface.add(todo);

        outputBoundary.addTodoSucceeded(toOutputData(todo));
    }

    private AddTodoOutputData toOutputData(Todo todo) {
        AddTodoOutputData.Priority priority = todo.priority() == Priority.HIGH ? AddTodoOutputData.Priority.HIGH : null;
        return new AddTodoOutputData(todo.id(), priority);
    }
}
