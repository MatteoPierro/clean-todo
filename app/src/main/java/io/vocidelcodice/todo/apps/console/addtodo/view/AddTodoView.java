package io.vocidelcodice.todo.apps.console.addtodo.view;

import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel;

import java.util.Observable;
import java.util.Observer;

public class AddTodoView implements Observer {
    @Override
    public void update(Observable observable, Object arg) {
        AddTodoViewModel viewModel = (AddTodoViewModel) observable;
        System.out.println("TODO created with Id: " + viewModel.id);
    }
}
