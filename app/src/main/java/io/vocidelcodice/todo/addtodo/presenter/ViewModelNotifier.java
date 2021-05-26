package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.apps.console.addtodo.view.AddTodoView;

public interface ViewModelNotifier {
    void subscribe(AddTodoView view);

    void notifyViews(AddTodoViewModel viewModel);
}
