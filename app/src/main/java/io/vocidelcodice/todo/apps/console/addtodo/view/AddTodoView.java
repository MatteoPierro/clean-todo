package io.vocidelcodice.todo.apps.console.addtodo.view;

import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel;

import java.util.Observable;
import java.util.Observer;

public class AddTodoView implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        AddTodoViewModel viewModel = (AddTodoViewModel) arg;
        if (viewModel.errorMessage.isBlank()) {
            System.out.println(viewModel.message);
        } else {
            System.err.println(viewModel.errorMessage);
        }
    }
}
