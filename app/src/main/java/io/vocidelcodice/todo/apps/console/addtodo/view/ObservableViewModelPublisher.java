package io.vocidelcodice.todo.apps.console.addtodo.view;

import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel;
import io.vocidelcodice.todo.addtodo.presenter.ViewModelPublisher;
import io.vocidelcodice.todo.addtodo.presenter.ViewModelSubscriber;

import java.util.Observable;
import java.util.Observer;

public class ObservableViewModelPublisher extends Observable implements ViewModelPublisher {
    @Override
    public void subscribe(ViewModelSubscriber subscriber) {
        addObserver((Observer) subscriber);
    }

    @Override
    public void publish(AddTodoViewModel viewModel) {
        setChanged();
        notifyObservers(viewModel);
    }
}
