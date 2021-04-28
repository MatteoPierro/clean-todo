package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData;

public class AddTodoPresenter implements AddTodoOutputBoundary {
    private final AddTodoViewModel viewModel;

    public AddTodoPresenter(AddTodoViewModel viewModel) {
        this.viewModel = viewModel;
    }

    @Override
    public void addTodoSucceeded(AddTodoOutputData addTodoOutputData) {
        viewModel.id = idToString(addTodoOutputData.id);
        viewModel.priority = priorityToString(addTodoOutputData.priority);
        viewModel.color = colorForPriority(addTodoOutputData.priority);
        viewModel.notifyViews();
    }

    private AddTodoViewModel.Color colorForPriority(AddTodoOutputData.Priority priority) {
        if (priority == AddTodoOutputData.Priority.HIGH) return AddTodoViewModel.Color.Red;
        return AddTodoViewModel.Color.Green;
    }

    private String idToString(Integer id) {
        return String.valueOf(id);
    }

    private String priorityToString(AddTodoOutputData.Priority priority) {
        return priority.name();
    }
}
