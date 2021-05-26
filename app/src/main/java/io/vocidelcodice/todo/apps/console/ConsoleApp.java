package io.vocidelcodice.todo.apps.console;

import io.vocidelcodice.todo.addtodo.controller.AddTodoController;
import io.vocidelcodice.todo.addtodo.persistence.InMemoryAddTodoDataAccessInterface;
import io.vocidelcodice.todo.addtodo.presenter.AddTodoPresenter;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoDataAccessInterface;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoInputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoUseCase;
import io.vocidelcodice.todo.apps.console.addtodo.view.AddTodoView;
import io.vocidelcodice.todo.apps.console.addtodo.view.ObservableViewModelPublisher;

public class ConsoleApp {

    public static void main(String[] args) {
        AddTodoDataAccessInterface dataAccessInterface = new InMemoryAddTodoDataAccessInterface();

        ObservableViewModelPublisher viewModelPublisher = new ObservableViewModelPublisher();
        viewModelPublisher.addObserver(new AddTodoView());
        AddTodoOutputBoundary addTodoPresenter = new AddTodoPresenter(viewModelPublisher);

        AddTodoInputBoundary addTodoUseCase = new AddTodoUseCase(dataAccessInterface, addTodoPresenter);

        AddTodoController controller = new AddTodoController(addTodoUseCase);
        controller.addTodo(parseMessage(args));
    }

    private static String parseMessage(String[] args) {
        return args.length == 0 ? "" : args[0];
    }
}
