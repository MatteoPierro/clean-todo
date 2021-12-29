package io.vocidelcodice.todo.addtodo.persistence;

import io.vocidelcodice.todo.addtodo.entities.Todo;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoDataAccessInterface;

import java.util.ArrayList;
import java.util.List;

public class InMemoryAddTodoDataAccess implements AddTodoDataAccessInterface {
    private static final List<Todo> TODOS = new ArrayList<>();

    @Override
    public void add(Todo todo) {
        TODOS.add(todo);
    }
}
