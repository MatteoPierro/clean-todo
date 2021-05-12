package io.vocidelcodice.todo.apps.console;

// controller module
import io.vocidelcodice.todo.addtodo.controller.AddTodoController;

// database adapter module
import io.vocidelcodice.todo.addtodo.persistence.InMemoryAddTodoDataAccessInterface;

// presenter module
import io.vocidelcodice.todo.addtodo.presenter.AddTodoPresenter;
import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel;

// usecase module
import io.vocidelcodice.todo.addtodo.usecase.AddTodoDataAccessInterface;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoInputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoUseCase;

// console view module
import io.vocidelcodice.todo.apps.console.addtodo.view.AddTodoView;

// main module
public class ConsoleApp {

    public static void main(String[] args) {
        AddTodoDataAccessInterface dataAccessInterface = new InMemoryAddTodoDataAccessInterface();
        AddTodoView view = new AddTodoView();

        AddTodoPresenter addTodoPresenter = new AddTodoPresenter();
        addTodoPresenter.addObserver(view);

        AddTodoInputBoundary addTodoUseCase = new AddTodoUseCase(dataAccessInterface, addTodoPresenter);

        AddTodoController controller = new AddTodoController(addTodoUseCase);
        controller.addTodo(parseMessage(args));
    }

    private static String parseMessage(String[] args) {
        return args.length == 0 ? "" : args[0];
    }
}
