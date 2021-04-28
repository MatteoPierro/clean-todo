package io.vocidelcodice.todo.apps.console;

import io.vocidelcodice.todo.addtodo.controller.AddTodoController;
import io.vocidelcodice.todo.addtodo.persistence.InMemoryAddTodoDataAccessInterface;
import io.vocidelcodice.todo.addtodo.presenter.AddTodoPresenter;
import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoDataAccessInterface;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoInputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoUseCase;
import io.vocidelcodice.todo.apps.console.addtodo.view.AddTodoView;

public class ConsoleApp {

    public static void main(String[] args) {
        AddTodoDataAccessInterface dataAccessInterface = new InMemoryAddTodoDataAccessInterface();
        AddTodoView view = new AddTodoView();

        AddTodoViewModel viewModel = new AddTodoViewModel();
        viewModel.addObserver(view);
        AddTodoOutputBoundary addTodoPresenter = new AddTodoPresenter(viewModel);

        AddTodoInputBoundary addTodoUseCase = new AddTodoUseCase(dataAccessInterface, addTodoPresenter);

        AddTodoController controller = new AddTodoController(addTodoUseCase);
        controller.addTodo(args[0]);
    }
}
