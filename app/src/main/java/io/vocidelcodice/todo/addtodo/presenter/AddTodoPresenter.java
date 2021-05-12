package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoViolations;

import java.util.Observable;

public class AddTodoPresenter extends Observable implements AddTodoOutputBoundary {

    @Override
    public void addTodoSucceeded(AddTodoOutputData addTodoOutputData) {
        AddTodoViewModel viewModel = AddTodoViewModel.success(
                idToString(addTodoOutputData.id),
                priorityToString(addTodoOutputData.priority),
                colorForPriority(addTodoOutputData.priority),
                successMessageFor(addTodoOutputData));
        notifyViews(viewModel);
    }

    @Override
    public void addTodoFailed(AddTodoViolations violation) {
        AddTodoViewModel viewModel = AddTodoViewModel.failure(violationToString(violation));
        notifyViews(viewModel);
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
