package io.vocidelcodice.todo.apps.console.addtodo.view;

import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel;
import io.vocidelcodice.todo.addtodo.presenter.ViewModelPublisher;

import java.util.Observable;

public class ObservableViewModelPublisher extends Observable implements ViewModelPublisher {

    @Override
    public void publish(AddTodoViewModel viewModel) {
        setChanged();
        notifyObservers(viewModel);
    }
}
