package io.vocidelcodice.todo.apps.console.addtodo.view;

import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel;
import io.vocidelcodice.todo.addtodo.presenter.ViewModelSubscriber;

import java.util.Observable;
import java.util.Observer;

public class AddTodoView implements Observer, ViewModelSubscriber {
    @Override
    public void update(Observable observable, Object arg) {
        AddTodoViewModel viewModel = (AddTodoViewModel) arg;

        System.out.println(colorFrom(viewModel) + messageFrom(viewModel));
    }

    private String colorFrom(AddTodoViewModel viewModel) {
        if (viewModel.color == AddTodoViewModel.Color.Red) {
            return "\033[0;31m";
        } else if (viewModel.color == AddTodoViewModel.Color.Green) {
            return "\033[0;32m";
        } else {
            return "\u001B[33m"; // Yellow
        }
    }

    private String messageFrom(AddTodoViewModel viewModel) {
        if (viewModel.errorMessage.isBlank()) {
            return viewModel.message;
        } else {
            return viewModel.errorMessage;
        }
    }
}
