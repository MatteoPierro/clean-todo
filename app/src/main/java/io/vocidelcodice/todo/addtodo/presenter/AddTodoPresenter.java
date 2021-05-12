package io.vocidelcodice.todo.addtodo.presenter;

import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputBoundary;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoOutputData;
import io.vocidelcodice.todo.addtodo.usecase.AddTodoViolations;

import java.util.Observable;

public class AddTodoPresenter extends Observable implements AddTodoOutputBoundary {

    @Override
    public void addTodoSucceeded(AddTodoOutputData addTodoOutputData) {
        AddTodoViewModel viewModel = new AddTodoViewModel(
                idToString(addTodoOutputData.id),
                priorityToString(addTodoOutputData.priority),
                colorForPriority(addTodoOutputData.priority),
                addTodoOutputData.message,
                ""
        );
        notifyViews(viewModel);
    }

    @Override
    public void addTodoFailed(AddTodoViolations violation) {
        AddTodoViewModel viewModel = new AddTodoViewModel(
                "",
                "",
                null,
                "",
                violationToString(violation)
        );
        notifyViews(viewModel);
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
