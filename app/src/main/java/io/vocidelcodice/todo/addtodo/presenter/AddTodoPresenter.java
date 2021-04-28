package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData;

public class AddTodoPresenter implements AddTodoOutputBoundary {
    private AddTodoViewModel viewModel;

    @Override
    public void addTodoSucceeded(AddTodoOutputData addTodoOutputData) {
        this.viewModel.id = idToString(addTodoOutputData.id);
        this.viewModel.priority = priorityToString(addTodoOutputData.priority);
        this.viewModel.color = colorForPriority(addTodoOutputData.priority);
        this.viewModel.notifyAll();
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
