package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.apps.console.addtodo.view.AddTodoView;

import java.util.Observable;

public class ObservableViewModelNotifier extends Observable implements ViewModelNotifier {
    @Override
    public void subscribe(AddTodoView view) {
        addObserver(view);
    }

    @Override
    public void notifyViews(AddTodoViewModel viewModel) {
        setChanged();
        notifyObservers(viewModel);
    }
}
