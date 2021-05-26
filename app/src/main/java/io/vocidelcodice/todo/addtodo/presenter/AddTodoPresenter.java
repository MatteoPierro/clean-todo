package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.addtodo.presenter.AddTodoViewModel.Color;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoViolations;
import io.vocidelcodice.todo.apps.console.addtodo.view.AddTodoView;

import java.util.Observable;

public class AddTodoPresenter implements AddTodoOutputBoundary, ViewModelNotifier {

    private final ObservableViewModelNotifier observableViewModelNotifier = new ObservableViewModelNotifier();

    @Override
    public void subscribe(AddTodoView view) {
        observableViewModelNotifier.subscribe(view);
    }

    @Override
    public void addTodoSucceeded(AddTodoOutputData addTodoOutputData) {
        AddTodoViewModel viewModel = AddTodoViewModel.success(
                successMessageFor(addTodoOutputData),
                colorForPriority(addTodoOutputData.priority)
        );
        observableViewModelNotifier.notifyViews(viewModel);
    }

    @Override
    public void addTodoFailed(AddTodoViolations violation) {
        AddTodoViewModel viewModel = AddTodoViewModel.failure(violationToString(violation), Color.Red);
        observableViewModelNotifier.notifyViews(viewModel);
    }

    private String successMessageFor(AddTodoOutputData addTodoOutputData) {
        return "TODO created with Id: " + idToString(addTodoOutputData.id)
                + " priority: " + priorityToString(addTodoOutputData.priority)
                + " message: " + addTodoOutputData.message;
    }

    private String violationToString(AddTodoViolations violation) {
        if (violation == AddTodoViolations.EMPTY_MESSAGE) {
            return "You must specify a message";
        }

        return "";
    }

    @Override
    public void notifyViews(AddTodoViewModel viewModel) {
        observableViewModelNotifier.notifyViews(viewModel);
    }

    private Color colorForPriority(AddTodoOutputData.Priority priority) {
        if (priority == AddTodoOutputData.Priority.HIGH) return Color.Green;
        return Color.Yellow;
    }

    private String idToString(Integer id) {
        return String.valueOf(id);
    }

    private String priorityToString(AddTodoOutputData.Priority priority) {
        return priority.name();
    }
}
