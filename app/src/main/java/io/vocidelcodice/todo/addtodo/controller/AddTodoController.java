package io.vocidelcodice.todo.addtodo.controller;

import io.vocidelcodice.todo.addtodo.usecase.AddTodoInputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoInputData;

public class AddTodoController {
    private AddTodoInputBoundary addTodoUseCase;

    public AddTodoController(AddTodoInputBoundary addTodoUseCase) {
        this.addTodoUseCase = addTodoUseCase;
    }

    public void addTodo(String message) {
        addTodoUseCase.addTodo(new AddTodoInputData(message));
    }
}
