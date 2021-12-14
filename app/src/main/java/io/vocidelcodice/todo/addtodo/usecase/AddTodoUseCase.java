package io.vocidelcodice.todo.addtodo.usecase;

import io.vocidelcodice.todo.addtodo.entities.Priority;
import io.vocidelcodice.todo.addtodo.entities.Todo;

public class AddTodoUseCase implements AddTodoInputBoundary {
    private final AddTodoDataAccessInterface dataAccessInterface;
    private final AddTodoOutputBoundary outputBoundary;

    public AddTodoUseCase(AddTodoDataAccessInterface dataAccessInterface, AddTodoOutputBoundary outputBoundary) {
        this.dataAccessInterface = dataAccessInterface;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void execute(AddTodoInputData addTodoInputData) {
        if (isEmptyMessage(addTodoInputData.message)) {
            outputBoundary.addTodoFailed(AddTodoViolations.EMPTY_MESSAGE);
            return;
        }

        Todo todo = new Todo(123, Priority.HIGH, addTodoInputData.message);
        dataAccessInterface.add(todo);

        outputBoundary.addTodoSucceeded(toOutputData(todo));
    }

    private boolean isEmptyMessage(String message) {
        return message == null || message.isBlank();
    }

    private AddTodoOutputData toOutputData(Todo todo) {
        AddTodoOutputData.Priority priority = todo.priority() == Priority.HIGH ? AddTodoOutputData.Priority.HIGH : null;
        return new AddTodoOutputData(todo.id(), priority, todo.message());
    }
}
