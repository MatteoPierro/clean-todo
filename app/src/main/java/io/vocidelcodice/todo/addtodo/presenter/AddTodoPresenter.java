package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData;

import java.util.Observable;

public class AddTodoPresenter extends Observable implements AddTodoOutputBoundary {

    @Override
    public void addTodoSucceeded(AddTodoOutputData addTodoOutputData) {
        AddTodoViewModel viewModel = new AddTodoViewModel();
        viewModel.id = idToString(addTodoOutputData.id);
        viewModel.priority = priorityToString(addTodoOutputData.priority);
        viewModel.color = colorForPriority(addTodoOutputData.priority);
        notifyViews(viewModel);
    }

    private void notifyViews(AddTodoViewModel viewModel) {
        setChanged();
        notifyObservers(viewModel);
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
