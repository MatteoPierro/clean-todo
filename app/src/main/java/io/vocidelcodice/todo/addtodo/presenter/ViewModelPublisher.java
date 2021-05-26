package io.vocidelcodice.todo.addtodo.presenter;

public interface ViewModelPublisher {
    void subscribe(ViewModelSubscriber subscriber);

    void publish(AddTodoViewModel viewModel);
}
